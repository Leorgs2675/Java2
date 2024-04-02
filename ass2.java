/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package osaimunnn;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ass2 extends javax.swing.JFrame {
  db jdbc = new db();
 
    List<sinhvien> sv = new ArrayList<>();
      int index =0;
    public ass2() {
        initComponents();
        loaddataba();
    }

   public void loaddataba(){
    try {
           
    String sql = "SELECT MASV,HOTEN,EMAIL,SODT,GIOITINH,DIACHI  FROM SINHVIEN";
        DefaultTableModel model=  (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
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
   
model.addRow(new Object[]{ list.getMa(), list.getTen(), list.getEmail(), list.getSdt(), list.isGioitinh() ? "nam" : "nu", list.getDichi(), imagePath});
        }
      
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("loi ket noi"+e);
    }
 this.diplay(index);
    
}
   
public void diplay(int index){
    // Biểu tượng cho nam và nữdelivery-boy.png"woman.png
ImageIcon maleIcon = new ImageIcon("/Users/mac/Downloads/24px/delivery-boy.png");
ImageIcon femaleIcon = new ImageIcon("/Users/mac/Downloads/24px/woman.png");
    sinhvien list =new sinhvien();
    list = this.sv.get(index);
    txtmasv.setText(list.getMa());
    txthoten.setText(list.getTen());
    txtsdt.setText(String.valueOf(list.getSdt()));
    txtemail.setText(list.getEmail());
    txadiachi.setText(list.getDichi());
    if (list.isGioitinh()) {
       jToggleButton1.setIcon(maleIcon); // Set hình ảnh nam
       jRadioButton1.setSelected(true);
       jRadioButton2.setSelected(false);
    }else{    
       jToggleButton1.setIcon(femaleIcon); // Set hình ảnh nữ
       jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(true);
    }
}
public void them(){
    try {
        String sql = "INSERT INTO SINHVIEN(MASV, HOTEN, EMAIL, SODT, GIOITINH, DIACHI) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = db.sConn.prepareStatement(sql);
        pst.setString(1, txtmasv.getText());
        pst.setString(2, txthoten.getText());
        pst.setString(3, txtemail.getText());
        pst.setInt(4, Integer.parseInt(txtsdt.getText()));
        pst.setBoolean(5, jRadioButton1.isSelected());
        pst.setString(6, txadiachi.getText());
        
        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0)
            System.out.println("Thêm mới thành công");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, e);
    }
}
public void sua(){
    try {
        String sql = "UPDATE SINHVIEN SET HOTEN=?, EMAIL=?, SODT=?, GIOITINH=?, DIACHI=? WHERE MASV = ?";
        PreparedStatement pst = db.sConn.prepareStatement(sql);
        pst.setString(6, txtmasv.getText());
        pst.setString(1, txthoten.getText());
        pst.setString(2, txtemail.getText());
        pst.setInt(3, Integer.parseInt(txtsdt.getText()));
        pst.setBoolean(4, jRadioButton1.isSelected());
        pst.setString(5, txadiachi.getText());
        
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) 
            System.out.println("Sửa thành công");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, "loi"+e);
    }
}
public void xoa(){
    try {
        String sql = "DELETE FROM SINHVIEN WHERE MASV = ?";
        PreparedStatement pst = db.sConn.prepareStatement(sql);
        pst.setString(1, txtmasv.getText());
        
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) 
            System.out.println("Xóa thành công");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txadiachi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("masv");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Email");

        jLabel5.setText("sđt");

        jLabel6.setText("giới tính ");

        jLabel7.setText("địa chỉ");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        txadiachi.setColumns(20);
        txadiachi.setRows(5);
        jScrollPane1.setViewportView(txadiachi);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "mã sv", "ho ten", "email", "sodt", "gioitinh", "dia chi", "hinh"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/new.png"))); // NOI18N
        jToggleButton1.setSelected(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/new-features.png"))); // NOI18N
        jButton1.setText("new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/save.png"))); // NOI18N
        jButton2.setText("save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/delete.png"))); // NOI18N
        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/send.png"))); // NOI18N
        jButton4.setText("update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("nam");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(86, 86, 86)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(37, 37, 37)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(33, 33, 33)
                                        .addComponent(jRadioButton2)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)))
                .addGap(0, 153, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int chon = jTable1.getSelectedRow();
        if (chon >=0) {
            diplay(chon);
       
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txthoten.setText("");
        txtemail.setText("");
          txtsdt.setText("");
          txtmasv.setText("");
          txadiachi.setText("");
          buttonGroup1.clearSelection();
          ImageIcon cc = new ImageIcon("/Users/mac/Downloads/24px/new.png");
          jToggleButton1.setIcon(cc);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       them();
       loaddataba();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int chon = jTable1.getSelectedRow();
        if(chon>=0){
        xoa();
        loaddataba();
        }else{
            JOptionPane.showMessageDialog(this,"chon o de xoa");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   int chon = jTable1.getSelectedRow();
        if(chon>=0){
            sua();
        loaddataba();
        }else{
            JOptionPane.showMessageDialog(this,"chon o de sua");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ass2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ass2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ass2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ass2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ass2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea txadiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
