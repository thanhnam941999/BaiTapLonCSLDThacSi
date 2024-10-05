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

public class SuDungDichVu {
    private int id;
    private String maSV;
    private String maDV;
    private Date ngaySuDung;
    private int soLuong;
    private double thanhTien;

    public SuDungDichVu(int id, String maSV, String maDV, Date ngaySuDung, int soLuong, double thanhTien) {
        this.id = id;
        this.maSV = maSV;
        this.maDV = maDV;
        this.ngaySuDung = ngaySuDung;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getMaDV() { return maDV; }
    public void setMaDV(String maDV) { this.maDV = maDV; }
    public Date getNgaySuDung() { return ngaySuDung; }
    public void setNgaySuDung(Date ngaySuDung) { this.ngaySuDung = ngaySuDung; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }
}