/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myKTXApp.QuanLyKTX;

/**
 *
 * @author thanhnam
 */
public class HoaDon {
    private int maHD;
    private String maSV;
    private int thang;
    private int nam;
    private double tienPhong;
    private double tienDichVu;
    private double tienGuiXe;
    private double tongTien;
    private String trangThai;

    public HoaDon(int maHD, String maSV, int thang, int nam, double tienPhong, double tienDichVu, double tienGuiXe, double tongTien, String trangThai) {
        this.maHD = maHD;
        this.maSV = maSV;
        this.thang = thang;
        this.nam = nam;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.tienGuiXe = tienGuiXe;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    // Getters
    public int getMaHD() { return maHD; }
    public String getMaSV() { return maSV; }
    public int getThang() { return thang; }
    public int getNam() { return nam; }
    public double getTienPhong() { return tienPhong; }
    public double getTienDichVu() { return tienDichVu; }
    public double getTienGuiXe() { return tienGuiXe; }
    public double getTongTien() { return tongTien; }
    public String getTrangThai() { return trangThai; }

    // Setters
    public void setMaHD(int maHD) { this.maHD = maHD; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public void setThang(int thang) { this.thang = thang; }
    public void setNam(int nam) { this.nam = nam; }
    public void setTienPhong(double tienPhong) { this.tienPhong = tienPhong; }
    public void setTienDichVu(double tienDichVu) { this.tienDichVu = tienDichVu; }
    public void setTienGuiXe(double tienGuiXe) { this.tienGuiXe = tienGuiXe; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    // toString method for easy printing
    @Override
    public String toString() {
        return "HoaDon{" +
               "maHD=" + maHD +
               ", maSV='" + maSV + '\'' +
               ", thang=" + thang +
               ", nam=" + nam +
               ", tienPhong=" + tienPhong +
               ", tienDichVu=" + tienDichVu +
               ", tienGuiXe=" + tienGuiXe +
               ", tongTien=" + tongTien +
               ", trangThai='" + trangThai + '\'' +
               '}';
    }
}
