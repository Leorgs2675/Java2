/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osaimunnn;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class repository {
   db jdbc = new db();
 
    List<sinhvien> sv = new ArrayList<>();
    public void loaddataba(){
    try {
           sv.clear();
    String sql = "SELECT MASV,HOTEN,EMAIL,SODT,GIOITINH,DIACHI  FROM SINHVIEN";
       
        
        Statement stm = db.sConn .createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
         sinhvien list = new sinhvien();
         list.setMa(rs.getString(1).trim());
            list.setTen(rs.getString(2).trim());
            list.setEmail(rs.getString(3));
            list.setSdt(rs.getInt(4));
            list.setGioitinh(rs.getBoolean(5));
            list.setDichi(rs.getString(6));
         this.sv.add(list);
         String imagePath;
if (list.isGioitinh()) {
   imagePath = "/Users/mac/Downloads/24px/delivery-boy.png"; // Đường dẫn hình ảnh nam
}
else {    
   imagePath = "/Users/mac/Downloads/24px/woman.png"; // Đường dẫn hình ảnh nữ
}
   

        }
      
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("loi ket noi"+e);
    }
 
    
}

    public repository() {
        
    }
   
}
