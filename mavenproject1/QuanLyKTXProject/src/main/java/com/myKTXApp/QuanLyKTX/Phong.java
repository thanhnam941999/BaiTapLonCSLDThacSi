/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myKTXApp.QuanLyKTX;

/**
 *
 * @author thanhnam
 */
public class Phong {
    private String soPhong;
    private String loaiPhong;
    private double donGia;
    private int soNguoiToiDa;
    private int soNguoiHienTai;

    public Phong(String soPhong, String loaiPhong, double donGia, int soNguoiToiDa, int soNguoiHienTai) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.donGia = donGia;
        this.soNguoiToiDa = soNguoiToiDa;
        this.soNguoiHienTai = soNguoiHienTai;
    }

    // Getters and setters
    public String getSoPhong() { return soPhong; }
    public void setSoPhong(String soPhong) { this.soPhong = soPhong; }
    public String getLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(String loaiPhong) { this.loaiPhong = loaiPhong; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public int getSoNguoiToiDa() { return soNguoiToiDa; }
    public void setSoNguoiToiDa(int soNguoiToiDa) { this.soNguoiToiDa = soNguoiToiDa; }
    public int getSoNguoiHienTai() { return soNguoiHienTai; }
    public void setSoNguoiHienTai(int soNguoiHienTai) { this.soNguoiHienTai = soNguoiHienTai; }
}
