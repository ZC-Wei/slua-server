package MainServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class UTLDaoImp implements UTLDao {
    @Override
    public UserTaskList getUTL(Integer UID){
        UserTaskList utl = new UserTaskList(UID);
        try {
            String sql = "select taskuid from usertasklist where useruid=? ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, UID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                utl.addTask(rs.getInt("taskuid"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            return utl;
        }
        return utl;
    }
    @Override
    public List<Task> getTasks(UserTaskList UTL){
        List<Task> tLists = new ArrayList<>();
        try {
            String sql = "select title, description, areanumber from task where uid=? ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            PreparedStatement ps = conn.prepareStatement(sql);
            Iterator<Integer> itr = UTL.getTaskUIDList().iterator();
            while(itr.hasNext()){
                ps.setInt(1, itr.next());
                ResultSet rs = ps.executeQuery();
                int uid, areaNumber, status;
                String title, description;
                while(rs.next()){
                    uid = UTL.getUserUID();
                    title = rs.getString("title");
                    description = rs.getString("description");
                    areaNumber = rs.getInt("areanumber");
                    tLists.add(new Task(uid, title, description, areaNumber));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            return tLists;
        }
        return tLists;
    }
}