/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    public String masv;
    public String hoten;
    public double diemta;
    public double diemtin;
    public double diemtc;
    public double diemtb;
    
    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, double diemta, double diemtin, double diemtc, double diemtb) {
        this.masv = masv;
        this.hoten = hoten;
        this.diemta = diemta;
        this.diemtin = diemtin;
        this.diemtc = diemtc;
        this.diemtb = diemtb;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDiemta() {
        return diemta;
    }

    public void setDiemta(double diemta) {
        this.diemta = diemta;
    }

    public double getDiemtin() {
        return diemtin;
    }

    public void setDiemtin(double diemtin) {
        this.diemtin = diemtin;
    }

    public double getDiemtc() {
        return diemtc;
    }

    public void setDiemtc(double diemtc) {
        this.diemtc = diemtc;
    }

    public double getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(double diemtb) {
        this.diemtb = diemtb;
    }
    
    
    public Object[] table(){
        
    return new Object[]{
        masv,hoten,diemta,diemtin,diemtc,diemtb=(diemta+diemtc+diemtin)/3
    };
}
}
