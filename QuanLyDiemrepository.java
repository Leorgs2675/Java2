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
import main.model.SinhVien;
/**
 *
 * @author ADMIN
 */
public class QuanLyDiemrepository {
    private List<SinhVien> list= new ArrayList<>();
    public List<SinhVien> getdata(){
        String query = "SELECT GRADE.MASV,STUDENTS.HOTEN,TIENGANH,TINHOC,GDTC FROM GRADE JOIN STUDENTS ON GRADE.MASV= STUDENTS.MASV";
        try (Connection conn= DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query)) {
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                SinhVien sv= new SinhVien();
                sv.setMasv(String.valueOf(rs.getString("MASV")));
                sv.setHoten(String.valueOf(rs.getString("HOTEN")));
                sv.setDiemta(Double.valueOf(rs.getDouble("TIENGANH")));
                sv.setDiemtin(Double.valueOf(rs.getDouble("TINHOC")));
                sv.setDiemtc(Double.valueOf(rs.getDouble("GDTC")));
                list.add(sv);
                
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
                return null;
        }
    }
}
