package main.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import main.model.NhanVien;
/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {
        private List<NhanVien> list= new ArrayList<>();
        public List<NhanVien> getData(){
            String query= "SELECT MaNV,HoTen,MatKhau,VaiTro FROM NhanVien";
            try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query) ){
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    NhanVien nhanvien= new NhanVien();
                    nhanvien.setMa(String.valueOf(rs.getInt("MaNV")));
                    nhanvien.setHoten(String.valueOf(rs.getString("HoTen")));
                    nhanvien.setMatkhau(String.valueOf(rs.getString("MatKhau")));
                    nhanvien.setVaitro(rs.getString("VaiTro").equalsIgnoreCase("VaiTro1")?true:false);
                    list.add(nhanvien);
                }
//                ps.execute();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
//        public NhanVien getSinhVienbyMa(String ma){
////            String query= "SELECT MaNV,HoTen,MatKhau,VaiTro FROM NhanVien WHERE MaNV =?";
//           try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(ma) ){
////               ps.setInt(1, ma);
//                ResultSet rs= ps.executeQuery();
//                while(rs.next()){
//                    NhanVien nhanvien= new NhanVien();
//                    nhanvien.setMa(String.valueOf(rs.getInt("MaNV")));
//                    nhanvien.setHoten("HoTen");
//                    nhanvien.setMatkhau("MatKhau");
//                    nhanvien.setVaitro(rs.getString("VaiTro").equalsIgnoreCase("VaiTro1")?true:false);
//                    return nhanvien;
//                }
////                ps.execute();
//                
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            } 
//            return null;
//        }
        public NhanVien getNhanVienByMa(int ma) {
        String query = "SELECT MaNV, MatKhau, HoTen, VaiTro FROM NhanVien WHERE MaNV = ?";
        try ( Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, ma);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMa(String.valueOf(rs.getInt("MaNV")));
                nhanVien.setHoten(String.valueOf(rs.getString("HoTen")));
                nhanVien.setMatkhau(String.valueOf(rs.getString("MatKhau")));
                nhanVien.setVaitro((rs.getString("VaiTro").equalsIgnoreCase("VaiTro1")) ? true : false);
                return nhanVien;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

        public void add(NhanVien nhanvien){
            String query= "INSERT INTO NHANVIEN(MANV,HoTen,MatKhau,VaiTro) VALUES (?,?,?,?)";
           try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query) ){
              
                ps.setInt(1,Integer.valueOf(nhanvien.getMa()));
                ps.setString(2, nhanvien.getHoten());
                ps.setString(3, nhanvien.getMatkhau());
                ps.setString(4, nhanvien.getVaitro()?"VaiTro1":"Nhân Viên");
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
                
            } 
           
        }
        public void delete(int ma){
            String query= "DELETE KhoaHoc WHERE MaNV = ? DELETE NGUOIHOC WHERE MaNV = ? DELETE NhanVien WHERE MaNV = ?";
           try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query) ){
               ps.setInt(1, ma);
               ps.setInt(2, ma);
               ps.setInt(3, ma);
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
                
            } 
           
        }
        public void capnhat(int ma,NhanVien nhanvien){
            String query= "UPDATE NhanVien SET MatKhau = ?, HoTen = ?, VaiTro = ? WHERE MaNV = ?";
           try (Connection conn = DBConnect.getConnection();PreparedStatement ps= conn.prepareStatement(query) ){
               
                ps.setString(1, nhanvien.getMatkhau());
                ps.setString(2, nhanvien.getHoten());
                ps.setString(3, nhanvien.getVaitro()?"VaiTro1":"Nhân Viên");
                ps.setInt(4,Integer.valueOf(nhanvien.getMa()));
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
                
            } 
           
        }
}
