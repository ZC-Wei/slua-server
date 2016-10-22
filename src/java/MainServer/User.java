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
public class User {
    private int uid; //unique identifiter
    private String username;
    private String password;
    private String email;
    private Integer areaNumber; // from 1-4, represent area no.1 to area no.4 etc
    private String deviceId;
    public User(){
        
    }
    public User(int UID, String Username, String Password, String Email, Integer areaNumber){
        //this.uid = UUID.randomUUID().toString();
        this.uid = UID;
        this.username = Username;
        this.password = Password;
        this.email = Email;
        this.areaNumber = areaNumber;
    }
    public int getUID(){
       return uid; 
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public Integer getAreaNumber(){
        return areaNumber;
    }
    public String getDeviceID(){
        return deviceId;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setAreaNumber(Integer newAreaNumber){
        this.areaNumber = newAreaNumber;
    }
    public void setDeviceID(String newDeviceID){
        this.deviceId = newDeviceID;
    }
}