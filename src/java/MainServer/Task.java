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
public class Task {
    private int uid;
    private String title;
    private String description;
    private int areaNumber;
    public Task(){
        
    };
    public Task(int UID, String Title, String Description, int AreaNumber){
        this.uid = UID;
        this.title = Title;
        this.description = Description;
        this.areaNumber = AreaNumber;
    }
    public int getUID(){
        return uid;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public int getAreaNumber(){
        return areaNumber;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
}
