package MainServer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wei
 */
public class TaskJSONService {
    public static List<Task> getListTask(){
        List<Task> tLists = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from task");
            int uid, areaNumber, status;
            String title, description;
            while(rs.next()){
                uid = rs.getInt("uid");
                title = rs.getString("title");
                description = rs.getString("description");
                areaNumber = rs.getInt("areaNumber");
                status = rs.getInt("status");
                tLists.add(new Task(uid, title, description, areaNumber));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserJSONService.class.getName()).log(Level.SEVERE, null, ex);
            return tLists;
        }
        return tLists;
    }
    
    public static void main(String[] arge) throws Exception{
        TaskJSONService con = new TaskJSONService();
        List<Task> temp = TaskJSONService.getListTask();
        
    }
}
