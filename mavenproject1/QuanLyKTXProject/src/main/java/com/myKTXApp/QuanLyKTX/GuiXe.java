/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myKTXApp.QuanLyKTX;

/**
 *
 * @author thanhnam
 */
import java.util.Date;

public class GuiXe {
    private String maSV;
    private String bienSoXe;
    private String loaiVe;
    private Date ngayDangKy;

    public GuiXe(String maSV, String bienSoXe, String loaiVe, Date ngayDangKy) {
        this.maSV = maSV;
        this.bienSoXe = bienSoXe;
        this.loaiVe = loaiVe;
        this.ngayDangKy = ngayDangKy;
    }

    // Getters and setters
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getBienSoXe() { return bienSoXe; }
    public void setBienSoXe(String bienSoXe) { this.bienSoXe = bienSoXe; }
    public String getLoaiVe() { return loaiVe; }
    public void setLoaiVe(String loaiVe) { this.loaiVe = loaiVe; }
    public Date getNgayDangKy() { return ngayDangKy; }
    public void setNgayDangKy(Date ngayDangKy) { this.ngayDangKy = ngayDangKy; }
}
