package com.myKTXApp.QuanLyKTX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/QuanLyKTX"; // Thay 'test' bằng tên database của bạn
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "N@m09041999";

    private static Connection connection = null;

    // Phương thức tạo kết nối
    public static Connection getConnection() throws SQLException {
        try {
             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection == null || connection.isClosed()) {
                throw new SQLException("Không thể tạo kết nối đến cơ sở dữ liệu");
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Phương thức thực hiện câu lệnh SQL SELECT và trả về ResultSet
    public static ResultSet executeSQL(String sql) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Lấy kết nối
            Connection connection = getConnection();

            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);  // Thực hiện câu lệnh SQL
                return resultSet;
            } else {
                System.out.println("Failed to connect to the MySQL database.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức thực hiện câu lệnh SQL INSERT, UPDATE, DELETE
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            
            return pstmt.executeUpdate();
        }
    }

    // Phương thức thực hiện câu lệnh DELETE
    public static int executeDelete(String sql, Object... params) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            // Lấy kết nối
            Connection connection = getConnection();

            if (connection != null) {
                pstmt = connection.prepareStatement(sql);
                // Set các tham số cho câu lệnh SQL, nếu có
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
                result = pstmt.executeUpdate();  // Thực hiện câu lệnh SQL
            } else {
                System.out.println("Failed to connect to the MySQL database.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
        return result;
    }
    
    // Đóng kết nối, statement, resultSet sau khi sử dụng
    public static void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null && !conn.isClosed()) conn.close();
            connection = null; // Đặt connection về null sau khi đóng
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet layTatCaSinhVien() throws SQLException {
        String query = "SELECT * FROM SinhVien";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
    
    public static ResultSet layTatCaPhong() throws SQLException {
        String query = "SELECT * FROM Phong";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
    
    public static ResultSet layKhachThamQuan() throws SQLException {
        String query = "SELECT * FROM KhachThamQuan";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    
    public static int countRooms() throws SQLException {
        String query = "SELECT COUNT(*) FROM Phong";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
    public static int countStudents() throws SQLException {
        String query = "SELECT COUNT(*) FROM SinhVien";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
    
    public static boolean deleteKhach(String cmt) {
        String sql = "DELETE FROM KhachThamQuan WHERE CMT = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cmt);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa khách thăm quan: " + e.getMessage());
            return false;
        }
    }

    public static boolean xoaSinhVien(String maSV) {
        String sql = "DELETE FROM SinhVien WHERE MaSV = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa sinh viên: " + e.getMessage());
            return false;
        }
    }
    
    public static ResultSet layTatCaDichVu() throws SQLException {
        String query = "SELECT * FROM DichVu";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
    
    public static boolean xoaDichVu(String maDV) throws SQLException {
        String sql = "DELETE FROM DichVu WHERE MaDV = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maDV);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
    
    public static ResultSet layTatCaSuDungDichVu() throws SQLException {
        String query = "SELECT SuDungDichVu.*, SinhVien.TenSV, DichVu.TenDV FROM SuDungDichVu " +
                       "JOIN SinhVien ON SuDungDichVu.MaSV = SinhVien.MaSV " +
                       "JOIN DichVu ON SuDungDichVu.MaDV = DichVu.MaDV";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
    
    public static boolean xoaSuDungDichVu(int id) throws SQLException {
        String sql = "DELETE FROM SuDungDichVu WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
    
    
    public static ResultSet traCuuSuDungDichVu(String searchTerm) throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT SuDungDichVu.*, SinhVien.TenSV, DichVu.TenDV FROM SuDungDichVu " +
                       "JOIN SinhVien ON SuDungDichVu.MaSV = SinhVien.MaSV " +
                       "JOIN DichVu ON SuDungDichVu.MaDV = DichVu.MaDV " +
                       "WHERE SuDungDichVu.MaSV LIKE ? OR SuDungDichVu.MaDV LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchTerm + "%");
        pstmt.setString(2, "%" + searchTerm + "%");
        return  pstmt.executeQuery();
    }
    
    public static boolean capNhatSuDungDichVu(String maSV, String maDV, java.sql.Date ngaySuDung, int soLuong, String id) throws SQLException {
        String sql = "UPDATE SuDungDichVu SET MaSV = ?, MaDV = ?, NgaySuDung = ?, SoLuong = ?, ThanhTien = ? WHERE ID = ?";
    
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            double donGia = layDonGiaDichVu(maDV);
            double thanhTien = soLuong * donGia;

            pstmt.setString(1, maSV);
            pstmt.setString(2, maDV);
            pstmt.setDate(3, ngaySuDung);
            pstmt.setInt(4, soLuong);
            pstmt.setDouble(5, thanhTien);
            pstmt.setInt(6, Integer.parseInt(id));

            int affectedRows = pstmt.executeUpdate();
            System.out.println("Affected rows: " + affectedRows);
            return affectedRows > 0;
        }
    }

    private static double layDonGiaDichVu(String maDV) throws SQLException {
        String sql = "SELECT DonGia FROM DichVu WHERE MaDV = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maDV);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("DonGia");
                }
            }
        }
        throw new SQLException("Không tìm thấy đơn giá cho dịch vụ: " + maDV);
    }
    
    public static boolean themSuDungDichVu(String maSV, String maDV, java.sql.Date ngaySuDung, int soLuong) throws SQLException {
        String sql = "INSERT INTO SuDungDichVu (MaSV, MaDV, NgaySuDung, SoLuong, ThanhTien) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Lấy đơn giá của dịch vụ
            double donGia = layDonGiaDichVu(maDV);
            double thanhTien = soLuong * donGia;

            pstmt.setString(1, maSV);
            pstmt.setString(2, maDV);
            pstmt.setDate(3, ngaySuDung);
            pstmt.setInt(4, soLuong);
            pstmt.setDouble(5, thanhTien);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
    
     public static ResultSet layQuanLyXeRaVao() throws SQLException {
        Connection conn = getConnection();
        String sql = "SELECT * FROM QuanLyXeRaVao ORDER BY GioVao DESC";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}
