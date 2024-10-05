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

public class LuuLuongXe {
    private int id;
    private String maSV;
    private String bienSoXe;
    private Date thoiGianLayXe;
    private Date thoiGianTraXe;
    private double tienPhi;

    public LuuLuongXe(int id, String maSV, String bienSoXe, Date thoiGianLayXe, Date thoiGianTraXe, double tienPhi) {
        this.id = id;
        this.maSV = maSV;
        this.bienSoXe = bienSoXe;
        this.thoiGianLayXe = thoiGianLayXe;
        this.thoiGianTraXe = thoiGianTraXe;
        this.tienPhi = tienPhi;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getBienSoXe() { return bienSoXe; }
    public void setBienSoXe(String bienSoXe) { this.bienSoXe = bienSoXe; }
    public Date getThoiGianLayXe() { return thoiGianLayXe; }
    public void setThoiGianLayXe(Date thoiGianLayXe) { this.thoiGianLayXe = thoiGianLayXe; }
    public Date getThoiGianTraXe() { return thoiGianTraXe; }
    public void setThoiGianTraXe(Date thoiGianTraXe) { this.thoiGianTraXe = thoiGianTraXe; }
    public double getTienPhi() { return tienPhi; }
    public void setTienPhi(double tienPhi) { this.tienPhi = tienPhi; }
}