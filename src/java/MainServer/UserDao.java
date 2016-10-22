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
public interface UserDao{
    public User login(String username, String password);
    public void setDeviceID(String username, String deviceID);
    public void signup(String username, String password, String email, Integer areaNumber);
}
