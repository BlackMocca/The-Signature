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
import java.util.Iterator;
import java.util.List;
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
    private File file ;
    
    public void init(){
        filePath = ENV.getENV("PATH_PROJECT_SIGNATURE")+ "/src/main/webapp/images/";
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
        response.setContentType("text/html;charset=UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            Iterator files = items.iterator();
            
            while(files.hasNext()) {
                FileItem fileItem = (FileItem) files.next();
                File file;
                // get value from input
                if(!fileItem.isFormField()){
                    String fieldName = fileItem.getFieldName();
                    String fileName = fileItem.getName();
                    String contentType = fileItem.getContentType();
                    boolean isInMemory = fileItem.isInMemory();
                    long sizeInBytes = fileItem.getSize();
                    
                    // Write the file
                
                    if( fileName.lastIndexOf("\\") >= 0 ) {
                      file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                   } else {
                      file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                   }
                    try {
                        fileItem.write(file) ;
                    } catch (Exception ex) {
                        Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   out.println("Uploaded Filename: " + fileName + "<br>");
                }
            }
             try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet FileUploadServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet FileUploadServlet at " + items + "</h1>");
                out.println("<h1>Servlet FileUploadServlet at " + repository + "</h1>");
                out.println("<h1>Servlet FileUploadServlet at " + file + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
               
        } catch (FileUploadException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        processRequest(request, response);
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
