/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import java.util.ArrayList;
import java.util.List;
import main.model.NhanVien;
/**
 *
 * @author ADMIN
 */
public class NhanVienService {
    private List<NhanVien> list = new ArrayList<>();
    
    
    public List<NhanVien> getData(){
        list.add(new NhanVien("001", "Nguyen Van A", "nva001", Boolean.TRUE));

        return list;
    }
    
    
}
