/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tran Thang
 */
public class ketNoi {
    Connection cnn;
    Statement stmt;
    void ketnoi(){
        try {
            Class.forName("com.hxtt.sql.access.AccessDriver");//nap driver
            cnn=DriverManager.getConnection("jdbc:access:/F:\\Java\\doAnJava\\cSoDuLieu.mdb");//tạo đối tượng
            stmt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//đối tuowngh truy vấn
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    void ngatketnoi(){
        try {
            if(stmt!=null)
                stmt.close();
            if(cnn!=null)
                cnn.close();
        } catch (Exception e) {
        }
    }
    
    
}
