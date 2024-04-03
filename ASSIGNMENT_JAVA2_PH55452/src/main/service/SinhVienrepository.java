/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import main.model.Students;
/**
 *
 * @author ADMIN
 */
public class SinhVienrepository {
    private List<Students> list = new ArrayList<>();
    public List<Students> getdata(){
        String query = "SELECT * FROM STUDENTS";
        try (Connection conn= DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query)){
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
               Students sd= new Students();
               sd.setMa(String.valueOf(rs.getString("MASV")));
               sd.setHoten(String.valueOf(rs.getString("HOTEN")));
               sd.setEmail(String.valueOf(rs.getString("EMAIL")));
               sd.setSdt(String.valueOf(rs.getString("SDT")));
               sd.setGioitinh(rs.getString("GIOITINH").equalsIgnoreCase("0")?true:false);
               sd.setDiachi(String.valueOf(rs.getString("DIACHI")));
               sd.setHinh(String.valueOf(rs.getString("HINH")));
               list.add(sd);
               
               
           }
           return list;
        } catch (Exception e) {
            e.printStackTrace();
                return null;
        }
    }
    public Students getSinhvienbyma(int ma){
        String query = "SELECT * FROM STUDENTS WHERE MASV=?";
        try(Connection conn= DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query)) {
            ps.setInt(1, ma);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                Students sd= new Students();
                sd.setMa(String.valueOf(rs.getString("MASV")));
                sd.setHoten(String.valueOf(rs.getString("HOTEN")));
                sd.setEmail(String.valueOf(rs.getString("EMAIL")));
                sd.setSdt(String.valueOf(rs.getString("SDT")));
                sd.setGioitinh(rs.getString("GIOITINH").equalsIgnoreCase("0")?true:false);
                sd.setDiachi(String.valueOf(rs.getString("DIACHI")));
                sd.setHinh(String.valueOf(rs.getString("HINH")));
                return sd;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public void add(Students sd){
        String query= "INSERT INTO STUDENTS(MASV,HOTEN,EMAIL,SDT,GIOITINH,DIACHI) VALUES (?,?,?,?,?,?)";
        try(Connection conn= DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query)) {
            ps.setInt(1,Integer.valueOf(sd.getMa()));
            ps.setString(2, sd.getHoten());
            ps.setString(3, sd.getEmail());
            ps.setString(4, sd.getSdt());
            ps.setString(5, sd.getGioitinh()?"0":"1");
            ps.setString(6, sd.getDiachi());
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void delete(int ma){
            String query= "DELETE GRADE WHERE MASV = ? DELETE STUDENTS WHERE MASV = ?";
           try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query) ){
               ps.setInt(1, ma);
               ps.setInt(2, ma);
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
                
            } 
           
        }
    
    public void update(int ma,Students sd){
        String query = "UPDATE STUDENTS SET HOTEN=?,EMAIL=?,SDT=?,DIACHI=? WHERE MASV =?";
        try(Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query)) {
            ps.setString(1, sd.getHoten());
            ps.setString(2, sd.getEmail());
            ps.setString(3, sd.getSdt());
            ps.setString(4, sd.getDiachi());
            ps.setInt(5, ma);
            ps.execute();
        } catch (Exception e) {
        }
    }
}
