package MainServer;


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
public interface UTLDao {
    public UserTaskList getUTL(Integer UID);
    public List<Task> getTasks(UserTaskList utl);
}
