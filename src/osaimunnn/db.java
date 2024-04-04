/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osaimunnn;
import java.sql.*;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author mac
 */
public class db {
    public static Connection sConn = null;
    static {                             // This is a static initializer block
        String strDbUrl = "jdbc:sqlserver://localhost:1433; "
                + "databaseName=QUANLYSINHVIEN;"  
                + "user=sa;"                
                + "password=Password.1;"
                + "encrypt=true;trustServerCertificate=true";
        if (sConn == null) {
            try {              
                sConn = DriverManager.getConnection(strDbUrl);
                DatabaseMetaData data = (DatabaseMetaData) sConn.getMetaData();
                System.out.println("OK");
                System.out.println("Driver Name: " + data.getDriverName());
                System.out.println("Driver Version: " + data.getDriverVersion());
                System.out.println("Product Name: " + data.getDatabaseProductName());
            } 
            catch (SQLException ex) {
                System.out.println("Khong the ket noi den CSDL \n" + ex);
            } 
        }
    }
    }
