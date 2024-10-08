/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.myKTXApp.QuanLyKTX;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thanhnam
 */
public class BaoCaoDoanhThuDichVu extends javax.swing.JFrame {

    private String maDV;
    private String tenDV;
    private int currentYear;

    public BaoCaoDoanhThuDichVu(String maDV, String tenDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        commonInit();
    }
    
    /**
     * Creates new form BaoCaoDoanhThuDichVu
     */
    public BaoCaoDoanhThuDichVu() {
        this.maDV = "";
        this.tenDV = "Tất cả dịch vụ";
        commonInit();
    }

    private void commonInit() {
        setCurrentYear();
        initComponents();
        customizeComponents();
        loadYearData();
        loadDoanhThuData(currentYear);
    }

    private void setCurrentYear() {
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    private void customizeComponents() {
        setTitle("Báo cáo doanh thu dịch vụ: " + tenDV);
        jLabel1.setText("Chọn năm cho dịch vụ: " + tenDV);
    }

    private void loadYearData() {
        try {
            String sql = "SELECT DISTINCT YEAR(NgaySuDung) as Nam FROM SuDungDichVu ";
            if (!maDV.isEmpty()) {
                sql += "WHERE MaDV = '" + maDV + "' ";
            }
            sql += "ORDER BY Nam DESC";
            
            ResultSet rs = MySqlConnect.executeSQL(sql);
            Vector<String> years = new Vector<>();
            while (rs.next()) {
                years.add(String.valueOf(rs.getInt("Nam")));
            }
            
            if (years.isEmpty() || !years.contains(String.valueOf(currentYear))) {
                years.add(String.valueOf(currentYear));
            }
            
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(years);
            jComboBox1.setModel(model);
            jComboBox1.setSelectedItem(String.valueOf(currentYear));
        } catch (SQLException e) {
            e.printStackTrace(); // In stack trace ra console
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu năm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadDoanhThuData(int year) {
        try {
            String sql = "SELECT MONTH(NgaySuDung) as Thang, SUM(ThanhTien) as DoanhThu " +
                         "FROM SuDungDichVu " +
                         "WHERE YEAR(NgaySuDung) = " + year + " ";
            if (!maDV.isEmpty()) {
                sql += "AND MaDV = '" + maDV + "' ";
            }
            sql += "GROUP BY MONTH(NgaySuDung) ORDER BY Thang ASC";
            
            ResultSet rs = MySqlConnect.executeSQL(sql);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            double totalRevenue = 0;
            while (rs.next()) {
                int thang = rs.getInt("Thang");
                double doanhThu = rs.getDouble("DoanhThu");
                totalRevenue += doanhThu;
                model.addRow(new Object[]{thang, String.format("%.2f VND", doanhThu)});
            }
            
            model.addRow(new Object[]{"Tổng", String.format("%.2f VND", totalRevenue)});
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu doanh thu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Báo cáo doanh thu dịch vụ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn năm");

        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tháng", "Doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selectedYear = (String) jComboBox1.getSelectedItem();
        if (selectedYear != null && !selectedYear.isEmpty()) {
            try {
                int year = Integer.parseInt(selectedYear);
                loadDoanhThuData(year);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Năm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaoCaoDoanhThuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCaoDoanhThuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCaoDoanhThuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCaoDoanhThuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoDoanhThuDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
