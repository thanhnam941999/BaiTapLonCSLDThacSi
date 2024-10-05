package com.myKTXApp.QuanLyKTX;

import java.sql.Date; // Để làm việc với kiểu ngày tháng từ cơ sở dữ liệu

public class CheckinXeMay {
 private String maSV;
    private String soCMT;
    private Date ngaySinh;
    private String lop;
    private String queQuan;
    private String soPhong;
    private Date ngayVaoO;

    public CheckinXeMay(String maSV, String soCMT, Date ngaySinh, String lop, String queQuan, String soPhong, Date ngayVaoO) {
        this.maSV = maSV;
        this.soCMT = soCMT;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.queQuan = queQuan;
        this.soPhong = soPhong;
        this.ngayVaoO = ngayVaoO;
    }

    // Getters and setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getSoCMT() { return soCMT; }
    public void setSoCMT(String soCMT) { this.soCMT = soCMT; }
    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }
    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }
    public String getQueQuan() { return queQuan; }
    public void setQueQuan(String queQuan) { this.queQuan = queQuan; }
    public String getSoPhong() { return soPhong; }
    public void setSoPhong(String soPhong) { this.soPhong = soPhong; }
    public Date getNgayVaoO() { return ngayVaoO; }
    public void setNgayVaoO(Date ngayVaoO) { this.ngayVaoO = ngayVaoO; }
}
