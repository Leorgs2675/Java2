/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi10;

import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author mac
 */
public class hiepden {
   private String ma;
   private String ten;
   private String email;
   private int sdt;
   private boolean gioitinh;
   private String dichi;
    private static final Logger LOG = Logger.getLogger(hiepden.class.getName());
  
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

    public boolean getGioitinh() {
        return gioitinh;
    }

    public String getDichi() {
        return dichi;
    }

    public static Logger getLOG() {
        return LOG;
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
   
}
