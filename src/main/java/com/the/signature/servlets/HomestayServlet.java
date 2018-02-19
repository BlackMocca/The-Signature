/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author huag1
 */
public class HomestayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomestayServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomestayServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Map<String, String> data = new HashMap<String,String>();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            Iterator files = items.iterator();
            while(files.hasNext()){
                FileItem item = (FileItem) files.next();
                if(!item.isFormField()){
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    data.put(fieldName, fileName.toLowerCase());
                } else {
                    String name = item.getFieldName();
                    String value = item.getString();
                    data.put(name, value);
                }
            }
            boolean validate = validateHomestay(data);
            System.out.println(validate);
            if (validate){
                RequestDispatcher rd = request.getRequestDispatcher("upload");
                rd.include(request, response);
                Map<String,ArrayList<String>> pathImage = (HashMap) request.getAttribute("pathImage");
                System.out.println(pathImage);
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(HomestayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    protected boolean validateHomestay(Map<String,String> data) {
        String[] documentTypeCheck = { ".png", ".jpg", ".jpeg", ".pdf" };
        if (data.containsKey("Hourse_document")){
            boolean check = false;
            String fileName = data.get("Hourse_document");
            for (String type : documentTypeCheck) {
               if(fileName.contains(type)){ 
                   check = true;
                   break;
               }
            }
        }
        if (data.containsKey("Homestay_License_document")){
            boolean check = false;
            String fileName = data.get("Hourse_document");
            for (String type : documentTypeCheck) {
               if(fileName.contains(type)){ 
                   check = true;
                   break;
               }
            }
        }
        if (data.containsKey("Homestay_name")){
            if(data.get("Homestay_name") == null || data.get("Homestay_name").equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Telno")){
            if(data.get("Telno") == null || data.get("Telno").equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Category")){
            if(data.get("Category") == null || data.get("Category").equalsIgnoreCase("") && data.get("Category") instanceof String)
               return false; 
        }
        if (data.containsKey("Open_time")){
            if(data.get("Open_time") == null || data.get("Open_time").equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Close_time")){
            if(data.get("Close_time") == null || data.get("Close_time").equalsIgnoreCase(""))
               return false; 
        }
        return true;
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
