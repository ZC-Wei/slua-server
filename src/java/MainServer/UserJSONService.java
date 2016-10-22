package MainServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wei
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserJSONService {
    public static List<User> getListUser(){
        List<User> uLists = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            User u = null;
            int uid;
            String username, password, email;
            Integer areaNumber;
            while(rs.next()){
                //System.out.println(rs.getString("username") + "\t" + rs.getString("password") + "\t" + rs.getString("email") + "\t" + rs.getInt("areaNumber"));
                uid = rs.getInt("uid");
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                areaNumber = rs.getInt("areaNumber");
                uLists.add(new User(uid, username, password, email, areaNumber));
            }
            rs.close();
            stmt.close();
            conn.close();
            //System.out.println(uLists);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserJSONService.class.getName()).log(Level.SEVERE, null, ex);
            return uLists;
        }
        return uLists;
    }
    
    public static void main(String[] arge) throws Exception{
        UserJSONService con = new UserJSONService();
        List<User> temp = UserJSONService.getListUser();        
    }
}

