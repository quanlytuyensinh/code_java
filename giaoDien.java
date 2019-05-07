/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_java;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Thang
 */
public class giaoDien extends javax.swing.JFrame {

    /**
     * Creates new form giaoDien
     */
    ketNoi kn = new ketNoi();
    private ResultSet rs;//chưa kết quả trả về
    private ResultSetMetaData rsmd;//chứa cấu chúc kết quả trả về
    Vector columnName;
    DefaultTableModel model;
    
    
    
    /*private void ketnoi(){
        try {
            Class.forName("com.hxtt.sql.access.AccessDriver");//nap driver
            kn.cnn=DriverManager.getConnection("jdbc:access:/F:\\Java\\doAnJava\\coSoDuLieu.mdb");//tạo đối tượng
            kn.stmt=kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//đối tuowngh truy vấn
            System.out.print("ket noi thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối: "+e.toString());
        }
    }
    private void ngatketnoi(){
        try {
            if(kn.stmt!=null)
                kn.stmt.close();
            if(kn.cnn!=null)
                kn.cnn.close();
        } catch (Exception e) {
        }
    }*/
    
    protected void loadData(){
        try {
            kn.ketNoi();
            String sql="select SBD, HoTen, GioiTinh, NgaySinh, TenNganh, Toan, Van, Anh\n" +
"from hoSoSinhVien,Diem,nganh\n" +
"where hoSoSinhVien.SBD = Diem.MaSo and nganh.MaNganh = hoSoSinhVien.MaNganh";
            rs = kn.stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tb.removeAll();
            tb.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }
    
    protected void timKiemSBD(){
        try {
            kn.ketNoi();
            String sql="select SBD, HoTen, GioiTinh, NgaySinh, TenNganh, Toan, Van, Anh\n" +
"from hoSoSinhVien,Diem,nganh\n" +
"where hoSoSinhVien.SBD = Diem.MaSo and nganh.MaNganh = hoSoSinhVien.MaNganh and SBD='"+txtTimKiem.getText()+"'";
            rs = kn.stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tb.removeAll();
            tb.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }
    
    protected void timKiemTen(){
        try {
            kn.ketNoi();
            String sql="select SBD, HoTen, GioiTinh, NgaySinh, TenNganh, Toan, Van, Anh\n" +
"from hoSoSinhVien,Diem,nganh\n" +
"where hoSoSinhVien.SBD = Diem.MaSo and nganh.MaNganh = hoSoSinhVien.MaNganh and HoTen='"+txtTimKiem.getText()+"'";
            rs = kn.stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            columnName = new Vector();
            int n=rsmd.getColumnCount();
            for(int i=1; i<=n; i++){
                columnName.addElement(rsmd.getColumnName(i));
            }
            model = new DefaultTableModel();
            model.setColumnIdentifiers(columnName);
            while(rs.next()){
                Vector  data = new Vector();
                for(int i=1; i<=n; i++){
                    Object o = rs.getObject(i);
                    data.addElement(o);
                }
                model.addRow(data);
            }
            tb.removeAll();
            tb.setModel(model);
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
            e.printStackTrace();
        }
    }
    boolean traSBD(){
        try {
            kn.ketNoi();
            String sql = "select SBD from hoSoSinhVien where SBD='"+txtTimKiem.getText()+"'";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true){
                return true;
            }
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        return false;
    }
    boolean traTen(){
        try {
            kn.ketNoi();
            String sql = "select HoTen from hoSoSinhVien where HoTen='"+txtTimKiem.getText()+"'";
            kn.stmt = kn.cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = kn.stmt.executeQuery(sql);
            if(rs.next()==true){
                return true;
            }
            kn.ngatketnoi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        return false;
    }
    
    public giaoDien() {
        initComponents();
        loadData();
        txtTimKiem.setToolTipText("Nhập SBD hoặc Họ Tên");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        tb.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb);

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Làm Mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Thống kê");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtTimKiem.setForeground(new java.awt.Color(255, 210, 193));
        txtTimKiem.setText("Nhập SBD hoặc Họ Tên");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseExited(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jButton7.setText("Tìm Kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 0, 0));
        jMenuBar1.setOpaque(false);

        jMenu1.setBackground(new java.awt.Color(204, 255, 255));
        jMenu1.setForeground(new java.awt.Color(0, 153, 153));
        jMenu1.setText("Tùy Chọn");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jMenuItem2.setText("Danh sách khoa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Thống kê");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addSV sv = new addSV();
        sv.setVisible(true);
        loadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoat!");
        if(kq==JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int i = tb.getSelectedRow();
        if(i==-1){
            JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn dòng để xóa");
            return;
        }
        int ok = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa"+tb.getValueAt(i, 1));
        if(ok == JOptionPane.YES_OPTION){
            try {
                kn.ketNoi();
                String sql=("delete from hoSoSinhVien where SBD='"
                        +tb.getValueAt(i, 0)+"'");
                
                String sql1=("delete from Diem where MaSo='"+tb.getValueAt(i, 0)+"'");
                kn.stmt.executeUpdate(sql);
                kn.stmt.executeUpdate(sql1);
                JOptionPane.showMessageDialog(this, "đã xóa");
                loadData();
                kn.ngatketnoi();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int a= tb.getSelectedRow();
        System.out.print(a);
        if(a==-1){
            JOptionPane.showMessageDialog(this, "Bạn phải chọn một dòng");
            return;
        }
        String[] dulieu  = new String[tb.getColumnCount()];
        for(int i=0; i<tb.getColumnCount(); i++){
            dulieu[i] = tb.getValueAt(a, i).toString();
        }
        Sua sua = new Sua(dulieu);
        sua.setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(txtTimKiem.getText().equals("")){
            loadData();
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số báo danh hoặc họ tên!");
        }
        else{
            try {
                Integer.parseInt(txtTimKiem.getText());
                if(traSBD()==true){
                    timKiemSBD();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Không có số báo danh này trong danh sách");
                }
            } catch (Exception e) {
                if(traTen()==true){
                    timKiemTen();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Không tồn tại tên này trong danh sách");
                }
            }
        }
        txtTimKiem.setForeground(Color.pink);
        txtTimKiem.setText("Nhập SBD hoặc Họ Tên");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseEntered
        
        //txtTimKiem.setText("");
        //txtTimKiem.setForeground(Color.BLACK);
        
    }//GEN-LAST:event_txtTimKiemMouseEntered

    private void txtTimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtTimKiemMouseExited

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        // TODO add your handling code here
        /*txtTimKiem.setText("Nhập SBD hoặc Họ Tên");
        txtTimKiem.setForeground(Color.orange);*/
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        // TODO add your handling code here:
        txtTimKiem.setText("");
        txtTimKiem.setForeground(Color.BLACK);
        
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseEntered

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new danhSachKhoa().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new ThongKe().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        /*int i=0;
        String[][] dulieu  = new String[i][tb.getColumnCount()];
        while(i!=4){
            for(int j=0; j<tb.getColumnCount(); j++){
                dulieu[i][j] = tb.getValueAt(i, j).toString();
            }
            i++;
        }
        ThongKe a = new ThongKe(dulieu);
        a.setVisible(true);*/
        new ThongKe().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(giaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(giaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(giaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(giaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new giaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
