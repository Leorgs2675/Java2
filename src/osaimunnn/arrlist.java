/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osaimunnn;

/**
 *
 * @author mac
 */
public class arrlist {
    public String masv;
    public String hoten;
    public double ta;
    public double tin;
    public double gdtc;


    public arrlist(String masv, String hoten, double ta, double tin, double gdtc) {
        this.masv = masv;
        this.hoten = hoten;
        this.ta = ta;
        this.tin = tin;
        this.gdtc = gdtc;
    }

    arrlist() {
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public void setGdtc(double gdtc) {
        this.gdtc = gdtc;
    }

   

    public String getMasv() {
        return masv;
    }

    public String getHoten() {
        return hoten;
    }

    public double getTa() {
        return ta;
    }

    public double getTin() {
        return tin;
    }

    public double getGdtc() {
        return gdtc;
    }



   public float getDiemTB() {
    return (float) ((this.getTa()+ this.getTin()+ this.getGdtc()) / 3.0f);
}
   
    
}
