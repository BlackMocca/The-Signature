/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.servlets;

import com.the.signature.models.Homestay;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        Map<String, Object> data = new HashMap<String,Object>();
        List<FileItem> uploadFileItem = new ArrayList<FileItem>();
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
                    uploadFileItem.add(item);
                } else {
                    String name = item.getFieldName();
                    String value = item.getString();
                    data.put(name, value);
                }
            }
            boolean validate = validateHomestay(data);
            if (validate){
                RequestDispatcher rd = request.getRequestDispatcher("upload");
                request.setAttribute("fileItem", uploadFileItem);
                rd.include(request, response);
                
                Map<String,ArrayList<Object>> pathImage = (HashMap) request.getAttribute("pathImage");
                Object[] additionContentImage = new Object[3];
                if (data.get("Content_image1") != null && pathImage.get("Content_image1") != null){
                    additionContentImage[0] = pathImage.get("Content_image1");
                }
                if (data.get("Content_image2") != null && pathImage.get("Content_image2") != null){
                    additionContentImage[1] = pathImage.get("Content_image2");
                }
                if (data.get("Content_image3") != null && pathImage.get("Content_image3") != null){
                    additionContentImage[2] = pathImage.get("Content_image3");
                }
                int countContentImage = additionContentImage.length;
                String contentImage = "";
                for (int i = 0; i < additionContentImage.length; i++){
                        contentImage += (String) additionContentImage[i];
                        if (countContentImage > 1){
                            --countContentImage;
                            contentImage += ",";
                        }
                    }
                data.put("Content_image",contentImage);
                data.put("User_id",1);
                data.put("Status", "Verifying");
                int insert = Homestay.createHomestay(data);
                System.out.println(insert);
            }
        } catch (Exception ex) {
            Logger.getLogger(HomestayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    protected boolean validateHomestay(Map<String,Object> data) {
        String[] documentTypeCheck = { ".png", ".jpg", ".jpeg", ".pdf" };
        if (data.containsKey("Hourse_document")){
            boolean check = false;
            String fileName = (String)data.get("Hourse_document");
            for (String type : documentTypeCheck) {
               if(fileName.contains(type)){ 
                   check = true;
                   break;
               }
            }
        }
        if (data.containsKey("Homestay_License_document")){
            boolean check = false;
            String fileName = (String)data.get("Hourse_document");
            for (String type : documentTypeCheck) {
               if(fileName.contains(type)){ 
                   check = true;
                   break;
               }
            }
        }
        if (data.containsKey("Homestay_name")){
            if(data.get("Homestay_name") == null || ((String)data.get("Homestay_name")).equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Telno")){
            if(data.get("Telno") == null || ((String)data.get("Telno")).equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Category")){
            if(data.get("Category") == null || ((String)data.get("Category")).equalsIgnoreCase("") && data.get("Category") instanceof String)
               return false; 
        }
        if (data.containsKey("Open_time")){
            if(data.get("Open_time") == null || ((String)data.get("Open_time")).equalsIgnoreCase(""))
               return false; 
        }
        if (data.containsKey("Close_time")){
            if(data.get("Close_time") == null || ((String)data.get("Close_time")).equalsIgnoreCase(""))
               return false; 
        }
        return true;
    }
    
    protected static String TypeArrayListToString(ArrayList<Object> values){
        int countValue = values.size();
        String value = "";
        Iterator iter = values.iterator();
        while(iter.hasNext()){
            value += (String) iter.next();
            if (countValue > 1){
                --countValue;
                value += ",";
            }
        }
        return value;
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
