package osaimunnn;


import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mac
 */
public class sinhvien {
    private String ma;
   private String ten;
   private String email;
   private int sdt;
   private boolean gioitinh;
   private String dichi;
   

    public sinhvien(String ma, String ten, String email, int sdt, boolean gioitinh, String dichi) {
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.dichi = dichi;
    }

    sinhvien() {
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDichi(String dichi) {
        this.dichi = dichi;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public int getSdt() {
        return sdt;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public String getDichi() {
        return dichi;
    }

  
}
