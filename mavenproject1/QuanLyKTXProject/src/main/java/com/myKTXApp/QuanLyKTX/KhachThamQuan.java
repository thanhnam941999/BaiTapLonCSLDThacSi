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

public class KhachThamQuan {
    private int id;
    private String cmt;
    private String ten;
    private Date ngaySinh;
    private String maSV;
    private Date ngayDen;

    public KhachThamQuan(int id, String cmt, String ten, Date ngaySinh, String maSV, Date ngayDen) {
        this.id = id;
        this.cmt = cmt;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.maSV = maSV;
        this.ngayDen = ngayDen;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCmt() { return cmt; }
    public void setCmt(String cmt) { this.cmt = cmt; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public Date getNgayDen() { return ngayDen; }
    public void setNgayDen(Date ngayDen) { this.ngayDen = ngayDen; }
}
