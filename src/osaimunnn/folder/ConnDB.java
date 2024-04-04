/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package osaimunnn.folder;

/**
 *
 * @author mac
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
/**
 *
 * @author TienTHM_1
 */
public class ConnDB {
    public static Connection sConn = null;
    public static void main(String[] args) {
        String strDbUrl = "jdbc:sqlserver://localhost:1433; "
                + "databaseName=QLNV;"  //Cấu hình theo tên database muốn kết nối
                + "user=sa;"                
                + "password=Password.1;"       //Cấu hình theo mật khẩu tài khoản sa
                + "encrypt=true;trustServerCertificate=true";
        if (sConn == null) {
            try {              
                sConn = DriverManager.getConnection(strDbUrl);
               String qu="SELECT * FROM SINHVIEN";
               Statement stm= sConn.createStatement();
               stm.execute(qu);
               ResultSet rs = stm.executeQuery(qu);
               while(rs.next()){
                   System.out.println(rs.getString(1));
               }
            } 
            catch (SQLException ex) {System.out.println("Khong the ket noi den CSDL \n" + ex);
            } 
    }
}

}

    