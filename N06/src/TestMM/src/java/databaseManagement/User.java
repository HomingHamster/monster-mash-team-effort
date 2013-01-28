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
public class User {
    @Id
    private String name;
    private String password;
    private boolean loggedIn;
    private int virtualMoney;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVirtualMoney(int virtualMoney) {
        this.virtualMoney = virtualMoney;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
   
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getVirtualMoney() {
        return virtualMoney;
    }
    
    
}
