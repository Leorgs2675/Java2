/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;



/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String ma;
    
    private String hoten;
    
    private String matkhau;
    
    private Boolean vaitro;

    public NhanVien() {
    }

    public NhanVien(String ma, String hoten, String matkhau, Boolean vaitro) {
        this.ma = ma;
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Boolean getVaitro() {
        return vaitro;
    }

    public void setVaitro(Boolean vaitro) {
        this.vaitro = vaitro;
    }
    
    public Object[] toRowTable(){
        return new Object[]{
           this.getMa(),this.getHoten(),this.getMatkhau(),this.getVaitro()?"Quan ly":"Nhan vien"
        };
        
    }
}
