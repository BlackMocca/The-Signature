/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.listener;

import com.the.signature.models.ENV;
import com.the.signature.utils.ConnectionBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author huag1
 */
public class DotenvContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootProject = System.getenv("PATH_PROJECT_SIGNATURE");
        ENV.setDotenv(Dotenv.configure().directory(rootProject).load());  
        initConnectionDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void initConnectionDatabase(){
        try {
            String host = ENV.getENV("DB_HOST");
            String port = ENV.getENV("DB_PORT");
            String DBName = ENV.getENV("DB_NAME");
            String username = ENV.getENV("DB_USERNAME");
            String password = ENV.getENV("DB_PASSWORD");
            ConnectionBuilder builder = new ConnectionBuilder(host,port,DBName,username,password);
            ConnectionBuilder.settingDatabase(builder);
        } catch (Exception ex) {
            Logger.getLogger(DotenvContextListener.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
