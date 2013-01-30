/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author Dan
 */
@Entity
public class MyUser {
    @Id
    private String username;
    private String userPassword;
    private int virtualMoney;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setVirtualMoney(int virtualMoney) {
        this.virtualMoney = virtualMoney;
    }
   
    
    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getVirtualMoney() {
        return virtualMoney;
    }
    
    public boolean isLoggedIn(){
       return true;
   }
    
    public int getFriendsNum(){
        return 5;
    }
    
    
}
