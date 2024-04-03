/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.service.QuanLyDiemrepository;
import main.model.SinhVien;


/**
 *
 * @author ADMIN
 */
public class QuanLyDiemSinhVien extends javax.swing.JFrame {
    private DefaultTableModel defaulttablemodel;
    private List<SinhVien> listview;
    private QuanLyDiemrepository repodiem= new QuanLyDiemrepository();
    /**
     * Creates new form QUẢNLÝĐIỂMSINHVIÊN
     */
    public QuanLyDiemSinhVien() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.listview = repodiem.getdata();
        this.filltable(listview);
        
    }
//    public void filltable(List<SinhVien> list){
//        this.defaulttablemodel = (DefaultTableModel)tblSinhVien.getModel();
//        this.defaulttablemodel.setRowCount(0);
//        for(SinhVien sv: list){
//            this.defaulttablemodel.addRow(sv.table());
//        }
//        
//    }

//    public SinhVien nhap() {
//    SinhVien sv = new SinhVien();
//    
//    String masv= txtMasv2.getText();
//    String ten = txtHoten.getText();
//    String ta = txtTienganh.getText();
//    String tin = txtTin.getText();
//    String gdtc = txtGDTC.getText();
//    double dta;
//    double dtin;
//    double dgdtc;
//     if (masv.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Chưa điền masv.");
//        return sv;
//    }else   
//      
//
//    if (ten.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Chưa điền tên.");
//        return sv;
//    }else
//    if(ten.matches(".[0-9]*")){
//            JOptionPane.showMessageDialog(this, "Yeu cau nhap chu");
//            return sv;
//        }
//
//    try {
//        dta = Double.parseDouble(ta);
//        dtin = Double.parseDouble(tin);
//        dgdtc = Double.parseDouble(gdtc);
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Điểm phải là số");
//        return sv;
//    }
//
//    if (dta < 0 || dta > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10");
//        return sv;
//    }
//    if (dgdtc < 0 || dgdtc > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10");
//        return sv;
//    }
//    if (dtin < 0 || dtin > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10");
//        return sv;
//    }
//
//    sv = new SinhVien(masv, ten, dta, dtin, dgdtc, dgdtc);
//    return sv;
//}
    public void filltable(List<SinhVien> list){
          this.defaulttablemodel = (DefaultTableModel) tblSinhVien.getModel();
    this.defaulttablemodel.setRowCount(0);

//        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
//            @Override
//            public int compare(SinhVien o1, SinhVien o2) {
//                if (o1.getDiemtb()<o2.getDiemtb()) {
//                    return 1;
//                } else if(o1.getDiemtb()>o2.getDiemtb()) {
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        };
//        
//       
//        Collections.sort(list, comp);
        
       int Rowcount= Math.min(list.size(), 3);
    for (int i=0; i<Rowcount;i++) {
        SinhVien sv= list.get(i);
        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.getDiemtb()<o2.getDiemtb()) {
                    return 1;
                } else if(o1.getDiemtb()>o2.getDiemtb()) {
                    return -1;
                }else{
                    return 0;
                }
            }
        };
        
       
        Collections.sort(list, comp);
        defaulttablemodel.addRow(sv.table());
        
    }
}
   
//    public void savesv(List<SinhVien> list){
//        for (SinhVien SV : list ) {
////       if (txtMasv2.getText().equals(SV.getMasv())) {
////       JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại. Vui lòng nhập mã khác!");
////           return;
////        
////        }
////    }  
////        
//      if(nhap() != null){
//        list.add(nhap());
//        filltable(list);
//        
//    }
//    
//    }
//    public void xoasv(){
//     int index = tblSinhVien.getSelectedRow();
//       list.remove(index);
//}
//    public void capnhat(List<SinhVien> list){
////        int selectedIndex = tblSinhVien.getSelectedRow();
////    if (selectedIndex == -1) {
////        JOptionPane.showMessageDialog(this, "Vui lòng chọn một học viên để cập nhật.");
////        return;
////    }
////    SinhVien sv = list.getFirst();
//    
//    String ta = txtTienganh.getText();
//    if (ta.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Chưa nhập điểm.");
//        return;
//    }
//    String tin = txtTin.getText();
//    if (ta.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Chưa nhập điểm.");
//        return;
//    }
//    String tc = txtGDTC.getText();
//    if (ta.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Chưa nhập điểm.");
//        return;
//    }
//
//    double diemta;
//    try {
//        diemta = Double.parseDouble(ta);
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Điểm phải là số.");
//        return;
//    }
//
//    if (diemta < 0 || diemta > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10.");
//        return;
//    }
//    double diemtin;
//    try {
//        diemtin = Double.parseDouble(tin);
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Điểm phải là số.");
//        return;
//    }
//
//    if (diemtin < 0 || diemtin > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10.");
//        return;
//    }
//    double diemtc;
//    try {
//        diemtc = Double.parseDouble(tc);
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Điểm phải là số.");
//        return;
//    }
//
//    if (diemtc < 0 || diemtc > 10) {
//        JOptionPane.showMessageDialog(this, "Điểm phải từ 0 - 10.");
//        return;
//    }
//    
//    sv.setHoten(txtHoten.getText());
//    sv.setDiemta(Double.parseDouble(txtTienganh.getText()));
//    sv.setDiemtin(Double.parseDouble(txtTin.getText()));
//    sv.setDiemtc(Double.parseDouble(txtGDTC.getText()));
//    list.add(nhap());
//    filltable(list);
//    txtDiemtb.setText("");
//    txtDiemtb.remove(this);
//    }
//    public void search(List<SinhVien> list){
//        
//        String searchma=txtMaSV.getText();
//       
//        for(SinhVien sv: list){
//            if(searchma.equalsIgnoreCase(sv.getMasv())){
//        txtMasv2.setText(sv.getMasv());
//        txtHoten.setText(sv.getHoten());
//        txtTienganh.setText(String.valueOf(sv.getDiemta()));
//        txtTin.setText(String.valueOf(sv.getDiemtin()));
//        txtGDTC.setText(String.valueOf(sv.getDiemtc()));
//        txtDiemtb.setText(String.valueOf(sv.getDiemtb()));  
//            }
//        }
//
//}

//    public void tb(){
//            
//            Double d1= Double.valueOf(txtTienganh.getText());
//            Double d2= Double.valueOf(txtTin.getText());
//            Double d3= Double.valueOf(txtGDTC.getText());
//            Double tb=(d1+d2+d3)/3;
//            String TB= String.valueOf(tb);
//            txtDiemtb.setText(TB);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtMaSV = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTin = new javax.swing.JTextField();
        txtMasv2 = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtTienganh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGDTC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiemtb = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Điểm Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã SV");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Tìm Kiếm");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Họ Tên SV");

        jLabel5.setText("Tiếng Anh");

        jLabel6.setText("Mã SV");

        jLabel7.setText("Giáo Dục TC");

        jLabel8.setText("Tin Học");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Điểm TB");

        txtDiemtb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDiemtb.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(208, 208, 208))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMasv2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTienganh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(txtDiemtb))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel9)))))))
                        .addGap(65, 65, 65))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMasv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel10)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnNew.setText("New");
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("3 Sinh viên có điểm cao nhất:");

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "Họ Và Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

//        search(listview);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        // TODO add your handling code here:
        txtHoten.setText("");
        txtHoten.remove(this);
        txtMasv2.setText("");
        txtMasv2.remove(this);
        txtTienganh.setText("");
        txtTienganh.remove(this);
        txtTin.setText("");
        txtTin.remove(this);
        txtGDTC.setText("");
        txtGDTC.remove(this);
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
//        nhap();
//        tb();
//        savesv();
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        int index = tblSinhVien.getSelectedRow();
//        String maSV= this.tblSinhVien.getValueAt(index, 0).toString();
//        SinhVien sv= list.get(index);
//        txtMasv2.setText(sv.getMasv());
//        txtHoten.setText(sv.getHoten());
//        txtTienganh.setText(String.valueOf(sv.getDiemta()));
//        txtTin.setText(String.valueOf(sv.getDiemtin()));
//        txtGDTC.setText(String.valueOf(sv.getDiemtc()));
//        txtDiemtb.setText(String.valueOf(sv.getDiemtb()));
//          int ma= Integer.parseInt(String.valueOf(maSV));
//        this.filltabletoform(ma);
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
//        this.xoasv();
      this.filltable(listview);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
//         capnhat();
//        tb();
//        capnhat(listview);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
//        search(list);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtDiemtb.setText("");
        txtDiemtb.remove(this);
    }//GEN-LAST:event_btnNewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiemSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JLabel txtDiemtb;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMasv2;
    private javax.swing.JTextField txtTienganh;
    private javax.swing.JTextField txtTin;
    // End of variables declaration//GEN-END:variables
}
