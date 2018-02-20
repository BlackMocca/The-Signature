/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.servlets;

import com.the.signature.models.ENV;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FileUploadServlet extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private String pathToImage;
    
    public void init(){
        pathToImage = "/src/main/webapp/images/";
        filePath = ENV.getENV("PATH_PROJECT_SIGNATURE")+ pathToImage;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        try {
            Iterator files = ((ArrayList)request.getAttribute("fileItem")).iterator();
            Map<String,ArrayList<String>> pathImage = new HashMap<String,ArrayList<String>>();
            ArrayList<String> pathList = new ArrayList<String>();
            while(files.hasNext()) {
                FileItem fileItem = (FileItem) files.next();
                if(!fileItem.isFormField()){
                    String path = FileUpload(fileItem);
                    String key = fileItem.getFieldName();
                    if(pathImage.containsKey(fileItem.getFieldName())){
                        pathList = pathImage.get(fileItem.getFieldName());
                        pathList.add(path);
                    }else{
                        pathList = new ArrayList<String>();
                        pathList.add(path);
                    }
                    pathImage.put(key, pathList);
                }
            }
            request.setAttribute("pathImage", pathImage);
        } catch (FileUploadException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected String FileUpload(FileItem fileItem) throws Exception{
        File file;
        String fieldName = fileItem.getFieldName();
        String fileName = fileItem.getName();
        String contentType = fileItem.getContentType();
        boolean isInMemory = fileItem.isInMemory();
        long sizeInBytes = fileItem.getSize();
        if( fileName.lastIndexOf("\\") >= 0 ) {
          file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
        } else {
          file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
        }
        fileItem.write(file);
        return pathToImage + fileName.substring(fileName.lastIndexOf("\\")+1);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
