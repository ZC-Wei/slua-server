package MainServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wei
 */
@WebServlet(urlPatterns = {"/TaskListServlet"})
public class TaskListServlet extends HttpServlet {

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
        response.setContentType("texthtml");
        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try{
            PrintWriter out = response.getWriter();
            Integer UID = Integer.parseInt(request.getParameter("UID"));
            UTLDao dao = new UTLDaoImp();
            UserTaskList utl = dao.getUTL(UID);
            List<Task> Tasks = dao.getTasks(utl);
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            for (Task task: Tasks){
                sb.append('{');
                sb.append("\"uid\":").append("\"").append(task.getUID()).append("\"").append(",");
                sb.append("\"title\":").append("\"").append(task.getTitle()).append("\"").append(",");
                sb.append("\"description\":").append("\"").append(task.getDescription()).append("\"").append(",");
                sb.append("\"areanumber\":").append("\"").append(task.getAreaNumber()).append("\"");
                sb.append('}').append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            out.write(new String(sb));
            out.flush();
            out.close();
        }catch(IOException | NumberFormatException e){
            System.out.println(e);
        }
         
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