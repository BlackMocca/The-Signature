/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.models;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author huag1
 */
public class ENV {
      private static Dotenv dotenv;
    public static String getENV(String key){
        
//        String rootProject = System.getenv("PATH_PROJECT_SIGNATURE");
//        Dotenv dotenv = Dotenv.configure().directory(rootProject).load();
//        Dotenv dotenv = Dotenv.configure().directory("C:\\Users\\huag1\\Documents\\NetBeansProjects\\The-Signature").load();

        return dotenv.get(key);  
//        return "";
    }

    public static Dotenv getDotenv() {
        return dotenv;
    }

    public static void setDotenv(Dotenv dotenv) {
        ENV.dotenv = dotenv;
    }
      
}
