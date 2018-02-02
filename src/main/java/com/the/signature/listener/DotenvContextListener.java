/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.listener;

import com.the.signature.models.ENV;
import io.github.cdimascio.dotenv.Dotenv;
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
        ENV.setDotenv(Dotenv.configure().directory(rootProject).ignoreIfMissing().load());    
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
