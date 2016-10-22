package MainServer;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wei
 */
public class UserTaskList {
    private int userUID;
    private List<Integer> taskUIDList;
    public UserTaskList(){
    
    };
    public UserTaskList(int useruid){
        userUID = useruid;
        taskUIDList = new ArrayList<>();
    };
    public int getUserUID(){
        return userUID;
    };
    public List<Integer> getTaskUIDList(){
        return taskUIDList;
    };
    public int getSizeOfList(){
      return taskUIDList.size();
    };
    public void addTask(Integer newTask){
          taskUIDList.add(newTask);
    };
    public void removeTask(Integer deleteTask){
        int index;
        index = taskUIDList.indexOf(deleteTask);
        taskUIDList.remove(index);
    };
}
