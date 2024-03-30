/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package buoi10;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;         // Use java.sql.Statement instead of java.beans.Statement
import java.sql.ResultSet;
import java.sql.SQLException;      // Import SQLException for handling SQL exceptions
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class lap4b2 extends javax.swing.JFrame {
List<hiepden> list = new ArrayList<>();
 BUOI10 bb= new BUOI10();
 
    public lap4b2() {
        initComponents();
            loadDatabaseDataIntoTable();
    }


public void loadDatabaseDataIntoTable(){
    try {
        Statement stmt = BUOI10.sConn.createStatement();

        String strSelect = "select MASV, HOTEN, EMAIL,SODT , GIOITINH, DIACHI from SINHVIEN";
        ResultSet rset = stmt.executeQuery(strSelect);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // Xóa tất cả các dòng hiện có trong bảng
        model.setRowCount(0);

        while (rset.next()) {
            hiepden sv = new hiepden();
            sv.setMa(rset.getString("MASV"));
            sv.setTen(rset.getString("HOTEN"));
            sv.setEmail(rset.getString("EMAIL"));
            sv.setSdt(rset.getInt("SODT"));
            sv.setGioitinh(rset.getBoolean("GIOITINH"));
            sv.setDichi(rset.getString("DIACHI"));
            
            String gender = sv.getGioitinh() ? "Nam" : "Nữ";
            list.add(sv);
            model.addRow(new Object[]{sv.getMa(), sv.getTen(), sv.getEmail(), sv.getSdt(), gender, sv.getDichi()});
        }

        model.fireTableDataChanged(); 
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
public void saveStudentToDatabase(hiepden sv) {
    String sql = "INSERT INTO SINHVIEN (MASV, HOTEN, EMAIL, SODT, GIOITINH, DIACHI) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement pst = BUOI10.sConn.prepareStatement(sql);
        pst.setString(1, sv.getMa());
        pst.setString(2, sv.getTen());
        pst.setString(3, sv.getEmail());
        pst.setInt(4, sv.getSdt());
        pst.setBoolean(5, sv.getGioitinh());
        pst.setString(6, sv.getDichi());
        
        pst.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

private int chiSoHienTai; // Khởi tạo là cần thiết, ví dụ chiSoHienTai = 0



// Tiếp theo, hàm display() của bạn sẽ được thay đổi như sau:
public void display(int i) {
    if(i >= 0 && i < list.size()) {
        hiepden sv = list.get(i);

        
        txtmasv.setText(sv.getMa());
        txtname.setText(sv.getTen());
        txtemail.setText(sv.getEmail());
        txtsdt.setText(String.valueOf(sv.getSdt()));
         if(sv.getGioitinh()) {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(false);
        } else {
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(true);
        }
        
        jTextArea1.setText(sv.getDichi());

        chiSoHienTai = i; // Dùng biến này để nhớ vị trí của sinh viên đang hiển thị
    }
}
 public void deleteStudentFromDatabase(int row) {
    hiepden sv = list.get(row);
    
    String sql = "DELETE FROM SINHVIEN WHERE MASV = ?";
    try {
        PreparedStatement pst = BUOI10.sConn.prepareStatement(sql);
        pst.setString(1, sv.getMa());
        pst.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        txtsdt = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("masv");

        jLabel2.setText("họ tên ");

        jLabel3.setText("số đt");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("giới tính ");

        jLabel6.setText("email");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("nam");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("nữ");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jToggleButton1.setText("add");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("delete");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("update");

        jToggleButton4.setText("save");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MASV", "HOTEN", "EMAIL", "SO DT ", "GIOI TINH", "DIA CHI"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jToggleButton5.setText("jToggleButton5");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setText("jToggleButton6");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton7.setText("jToggleButton7");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jToggleButton8.setText("jToggleButton8");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmasv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsdt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jToggleButton2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jToggleButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jToggleButton4)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton5)
                    .addComponent(jToggleButton6)
                    .addComponent(jToggleButton7)
                    .addComponent(jToggleButton8))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
    if(selectedRow >= 0) { // Just a safety check
        this.display(selectedRow);
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
    // Hành động cho nút 'Đầu'                   
     display(0);
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
       // Hành động cho nút 'Tiếp theo'
    display((chiSoHienTai + 1) % list.size());  
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
       // Hành động cho nút 'Trước'
     display((chiSoHienTai - 1 + list.size()) % list.size());
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
      // Hành động cho nút 'Cuối'                                              
    display(list.size() - 1);
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        txtmasv.setText("");
        txtname.setText("");
        txtemail.setText("");
        txtsdt.setText("");
   buttonGroup1.clearSelection();
   jTextArea1.setText("");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow >= 0) {
            deleteStudentFromDatabase(selectedRow);
            list.remove(selectedRow);
            ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(lap4b2.this, "Vui lòng chọn sinh viên để xóa");
        }
    }
});
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
    jToggleButton4.addActionListener(new ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        hiepden sv = new hiepden();
        
        sv.setMa(txtmasv.getText());
        sv.setTen(txtname.getText());
        sv.setEmail(txtemail.getText());

        try {
            sv.setSdt(Integer.parseInt(txtsdt.getText()));
        } catch(NumberFormatException ex) {
            ex.printStackTrace();
        }

        if (jCheckBox1.isSelected()) {
            sv.setGioitinh(true);
        } else if (jCheckBox2.isSelected()) {
            sv.setGioitinh(false);
        }

        sv.setDichi(jTextArea1.getText());
        
        saveStudentToDatabase(sv);

        loadDatabaseDataIntoTable();
    }
});
    }//GEN-LAST:event_jToggleButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(lap4b2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lap4b2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lap4b2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lap4b2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lap4b2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
