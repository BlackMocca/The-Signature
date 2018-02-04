/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.models;

import com.the.signature.utils.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huag1
 */
public class HelloWorld {
    private int id;
    private String message;

    public HelloWorld() {
    }

    public HelloWorld(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public HelloWorld getHelloWorld(){
        HelloWorld hello = null;
        try {
            Connection con = ConnectionBuilder.getMySqlCond();
            PreparedStatement pstmt = con.prepareStatement("select * from helloworld");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String message = rs.getString("message");
                hello = new HelloWorld(id,message);
            }
            return hello;
        } catch (SQLException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hello;
    }
    
}
