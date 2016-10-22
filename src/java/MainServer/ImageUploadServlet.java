package MainServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Wei
 */
@WebServlet(urlPatterns = {"/ImageUploadServlet"})
public class ImageUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletFileUpload upload;
    private final long MAXsize = 4194304*2L;
    private String fileDir = null;
    
    public ImageUploadServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        FileItemFactory factory = new DiskFileItemFactory();
        this.upload = new ServletFileUpload(factory);
        this.upload.setSizeMax(this.MAXsize);
        fileDir = config.getServletContext().getRealPath("image");
        System.out.println("fileDir = " + fileDir);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            List<FileItem> items = this.upload.parseRequest(request);
            if (items != null && !items.isEmpty()) {
                for (FileItem item : items) {
                    String filename = item.getName();
                    String filepath = fileDir + File.separator + filename;
                    System.out.println("File path: " + filepath);
                    File file = new File(filepath);
                    InputStream inputStream = item.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    FileOutputStream fos = new FileOutputStream(file);
                    int f;
                    while ((f = bis.read()) != -1) {                        
                        fos.write(f);
                    }
                    fos.flush();
                    fos.close();
                    bis.close();
                    inputStream.close();
                    System.out.println("File: " + filename + "Uploaded");
                }
            }
            System.out.println("Uploaded!");
            out.write("Uploaded!");
        } catch (FileUploadException | IOException e) {
            System.out.println(e);
            out.write(fileDir);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
