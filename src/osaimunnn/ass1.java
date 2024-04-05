/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package osaimunnn;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mac
 */
public class ass1 extends javax.swing.JFrame {
List<arrlist> list = new ArrayList<>();
    db jdbc = new db();
   int index = 1;
    
   public ass1() {
    initComponents();
    setLocationRelativeTo(null);
    this.loadDataToArray();
    this.loadDataToTable();
}
   private void loadDataToTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0); // Clear old data
     Collections.sort(list, new Comparator<arrlist>() {
    @Override
    public int compare(arrlist std1, arrlist std2) {
        if (std1.getDiemTB() > std2.getDiemTB()) {
            return -1;
        } else if (std1.getDiemTB() < std2.getDiemTB()) {
            return 1;
        } else {
            return 0;
        }
    }
});
    for (int i = 0; i < 3 && i < list.size(); i++) {
        arrlist std = list.get(i);
        model.addRow(new Object[]{
            std.getMasv(), std.getHoten(), std.getTa(), std.getTin(), std.getGdtc(),std.getDiemTB()
        });
    }
}
 public void loadDataToArray() {
    try {
        list.clear(); // Thêm dòng này để xóa dữ liệu cũ
        System.out.println("OK");
        String sql = "SELECT GRADE.MASV, SINHVIEN.HOTEN, GRADE.TIENGANH, GRADE.TINHOC, GRADE.GDCD FROM SINHVIEN " +
                "INNER JOIN GRADE ON SINHVIEN.MASV = GRADE.MASV";

        Statement stm = db.sConn.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        while (resultSet.next()) {
            arrlist std = new arrlist();
            std.setMasv(resultSet.getString(1));
            std.setHoten(resultSet.getString(2));
            std.setTa(resultSet.getInt(3));
            std.setTin(resultSet.getInt(4));
            std.setGdtc(resultSet.getInt(5));
            list.add(std);
        }
    } catch (SQLException e) {
        System.out.println("Error " + e);
    }
    this.display(index);
}
     public void display(int index){
         arrlist list = new arrlist();
         list = this.list.get(index);
         txtmasv.setText(list.getMasv());
         txthoten.setText(list.getHoten());
         txttienganh.setText(String.valueOf(list.getTa() ));
          txttin.setText(String.valueOf(list.getTin() ));
           txtGdtc.setText(String.valueOf(list.getGdtc() ));
           jLabel8.setText(String.valueOf(list.getDiemTB()));
     }
  private boolean isValidScore(double score) {
    return score >= 0.0 && score <= 10.0;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        txttienganh = new javax.swing.JTextField();
        txttin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGdtc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("họ tên sv");

        jLabel2.setText("mã sv");

        jLabel3.setText("tiếng anh");

        jLabel4.setText("tin Hoc");

        jLabel7.setText("DiemTB");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));

        jLabel9.setText("GDTC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txthoten)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                        .addComponent(txttin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(txtGdtc))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel9))
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addComponent(txttienganh))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(txtmasv)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttienganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txttin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/new-features.png"))); // NOI18N
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/delete.png"))); // NOI18N
        jButton3.setText("Delete");
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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ma sv", "Họ tên", "Tiếng anh", "tin", "gdtc", "ĐIểm tb"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("QUẢN LÝ ĐIỂM  SINH VIÊN ");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel5.setText("mã sv");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/search.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap())
        );

        jLabel10.setText("top 3 sv có điểm cao nhất ");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/next-button.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/next.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/arrowhead.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/angle-left.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addGap(34, 34, 34)
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jButton8)
                            .addComponent(jButton7)))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


    try {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn sinh viên cần xóa điểm!");
        } else {
            String selectedMasv = list.get(selectedRow).getMasv();

            String sql = "UPDATE GRADE SET TIENGANH = NULL, TINHOC = NULL, GDCD = NULL WHERE MASV = ?";
            PreparedStatement pst = db.sConn.prepareStatement(sql);

            pst.setString(1, selectedMasv);

            pst.executeUpdate();

            loadDataToArray();
            loadDataToTable();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }   

    }//GEN-LAST:event_jButton3ActionPerformed
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    txthoten.setText("");
    txtmasv.setText("");
     txttienganh.setText("");
         txttin.setText("");
             txtGdtc.setText("")
                     ;
             jLabel8.setText("");
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 try {
        // Khởi tạo câu lệnh SQL
        String sql = "UPDATE GRADE SET TIENGANH = ?, TINHOC = ?, GDCD = ? WHERE MASV = ?";

        PreparedStatement pst = db.sConn.prepareStatement(sql);

        // Chuyển chuỗi thành số thực
        double tienganhScore = Double.parseDouble(txttienganh.getText());
        double tinScore = Double.parseDouble(txttin.getText());
        double gdtcScore = Double.parseDouble(txtGdtc.getText());

        // Kiểm tra xem điểm có nằm trong khoảng 0 đến 10 không
        if( !isValidScore(tienganhScore) || !isValidScore(tinScore) || !isValidScore(gdtcScore)) {
            JOptionPane.showMessageDialog(null, "Điểm số phải từ 0 đến 10. Vui lòng kiểm tra lại.");
            return;
        }

        // Đặt giá trị cho các tham số trong câu lệnh SQL
        pst.setDouble(1, tienganhScore);
        pst.setDouble(2, tinScore);
        pst.setDouble(3, gdtcScore);
        pst.setString(4, txtmasv.getText()); // giả sử bạn có một JTextField txtMasv để nhập MASV muốn cập nhật

        // Thực hiện câu lệnh SQL
    pst.executeUpdate();

        // Kiểm tra nếu có hàng nào được cập nhật
        
            // Gọi hàm để cập nhật dữ liệu trong ứng dụng
            loadDataToArray();
            loadDataToTable();
    
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       int selectedRow = jTable2.getSelectedRow();
    if(selectedRow >= 0) { // Just a safety check
        this.display(selectedRow);
    }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                                         
    
    
try {
        // Khởi tạo câu lệnh SQL
        String sql = "UPDATE GRADE SET TIENGANH = ?, TINHOC = ?, GDCD = ? WHERE MASV = ?";

        PreparedStatement pst = db.sConn.prepareStatement(sql);

        // Chuyển chuỗi thành số thực
        double tienganhScore = Double.parseDouble(txttienganh.getText());
        double tinScore = Double.parseDouble(txttin.getText());
        double gdtcScore = Double.parseDouble(txtGdtc.getText());

        // Kiểm tra xem điểm có nằm trong khoảng 0 đến 10 không
        if( !isValidScore(tienganhScore) || !isValidScore(tinScore) || !isValidScore(gdtcScore)) {
            JOptionPane.showMessageDialog(null, "Điểm số phải từ 0 đến 10. Vui lòng kiểm tra lại.");
            return;
        }

        // Đặt giá trị cho các tham số trong câu lệnh SQL
        pst.setDouble(1, tienganhScore);
        pst.setDouble(2, tinScore);
        pst.setDouble(3, gdtcScore);
        pst.setString(4, txtmasv.getText()); // giả sử bạn có một JTextField txtMasv để nhập MASV muốn cập nhật

        // Thực hiện câu lệnh SQL
        int updatedRows = pst.executeUpdate();

        // Kiểm tra nếu có hàng nào được cập nhật
        if(updatedRows > 0) {
            // Gọi hàm để cập nhật dữ liệu trong ứng dụng
            loadDataToArray();
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã sinh viên. Vui lòng kiểm tra lại.");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();

    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
  
     
    }//GEN-LAST:event_btnSearchMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        display(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
          if(index == 0){
            JOptionPane.showMessageDialog(rootPane, "This is first record");
            return;
        }
        this.display(--index);
    
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(index == list.size() - 1){
            JOptionPane.showMessageDialog(rootPane, "This is last record");
            return;
        }
        this.display(++index);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(list.isEmpty()){
        JOptionPane.showMessageDialog(rootPane, "No records available");
        return;
    }
    index = list.size() - 1;
    this.display(index);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
       
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
         try {
              String tim = txtSearch.getText();
        for (arrlist list:list) {
            if(tim.equalsIgnoreCase(list.getMasv())){
               txtmasv.setText(list.getMasv());
         txthoten.setText(list.getHoten());
         txttienganh.setText(String.valueOf(list.getTa() ));
          txttin.setText(String.valueOf(list.getTin() ));
           txtGdtc.setText(String.valueOf(list.getGdtc() ));
           jLabel8.setText(String.valueOf(list.getDiemTB()));
            }
            
            
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "deo tim thay");
        }
      
    }//GEN-LAST:event_btnSearchActionPerformed

   
   
public static void main(String args[]) {
 java.awt.EventQueue.invokeLater(new Runnable() {
 @Override
 public void run() {
 ass1 mainFrame = new ass1(); // Tạo một thể hiện của NewJFrame
 mainFrame.setVisible(true); // Hiển thị NewJFrame
 }
 });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtGdtc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txttienganh;
    private javax.swing.JTextField txttin;
    // End of variables declaration//GEN-END:variables

   
}
