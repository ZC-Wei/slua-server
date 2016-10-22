package MainServer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class UserDaoImp implements UserDao{

    @Override
    public User login(String username, String password) {
        try {
            String sql = "select uid, username, password, email, areanumber from user where username=? and password=? ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            PreparedStatement ps;
            ps= conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User(rs.getInt("uid"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getInt("areanumber"));
                ps.close();
                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void setDeviceID(String username, String deviceID){
        try {
            String sql = "update user set deviceid=? where username=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, deviceID);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void signup(String username, String password, String email, Integer areaNumber){
        try {
            String sql = "insert into user(name, password, email, areaNumber) values(?, ?, ?, ?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CrowdApp", "root", "123456");
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, areaNumber);
            ps.executeUpdate();
            ps.close();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}