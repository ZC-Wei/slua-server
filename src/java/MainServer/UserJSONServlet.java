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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wei
 */
public class UserJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        try{  
            PrintWriter out = response.getWriter();  
            List<User> users = UserJSONService.getListUser();       
            StringBuffer sb = new StringBuffer(); 
            sb.append('[');
            for (User user : users) { 
                sb.append('{');
                sb.append("\"UID\":").append("\"").append(user.getUID()).append("\"").append(","); 
                sb.append("\"username\":").append("\"").append(user.getUsername()).append("\"").append(",");  
                sb.append("\"password\":").append("\"").append(user.getPassword()).append("\"").append(",");  
                sb.append("\"email\":").append("\"").append(user.getEmail()).append("\"").append(",");
                sb.append("\"area number\":").append("\"").append(user.getAreaNumber()).append("\"").append(","); 
                sb.append('}').append(",");
            }  
            sb.deleteCharAt(sb.length() - 1);  
            sb.append(']');  
            out.write(new String(sb));  
            out.flush();  
            out.close();
        }catch(Exception e){  
            System.out.println(e);  
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
