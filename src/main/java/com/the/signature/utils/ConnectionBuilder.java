/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.utils;

import com.the.signature.models.ENV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huag
 */
public class ConnectionBuilder {
    private static Connection connection;
    private String host;
    private String port;
    private String DBName;
    private String username;
    private String password;
    private Map<String,String> options;

    public ConnectionBuilder(String host,String port, String DBName, String username, String password) {
        this(host,port,DBName,username,password,null);
    }

    public ConnectionBuilder(String host,String port, String DBName, String username, String password, Map<String, String> options) {
        this.host = host;
        this.port = port;
        this.DBName = DBName;
        this.username = username;
        this.password = password;
        this.options = options;
    }
    
    
    
    public static void settingDatabase(ConnectionBuilder builder) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionString = "jdbc:mysql://";
        if (builder.getHost().equalsIgnoreCase("localhost")){
           connectionString += builder.getHost() + "/" 
                                + builder.getDBName() + "?"
                                + "useUnicode=true&characterEncoding=UTF-8";
        } else {
           connectionString +=  builder.getHost()+ ":" + builder.getPort() + "/" 
                            + builder.getDBName() + "?"
                            + "useUnicode=true&characterEncoding=UTF-8";  
        }
        connection =  DriverManager.getConnection(connectionString, builder.getUsername(), builder.getPassword());
    }
    

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionBuilder.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

  

    
    
    
    
}


