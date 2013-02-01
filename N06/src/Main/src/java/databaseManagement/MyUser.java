/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Contains the methods relating to the 
 * management of users. User is an entity class that is persisted to the database.
 * @author Dan
 */
@Entity
public class MyUser {

    @Id
    private String username;
    private String userPassword;
    private boolean isLoggedIn;
    private boolean isActive;
    private int virtualMoney;
    /**
     * sets the user's username.
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * sets a user's password.
     * @param userPassword 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    /**
     * sets the user's money.
     * @param virtualMoney 
     */
    public void setVirtualMoney(int virtualMoney) {
        this.virtualMoney = virtualMoney;
    }
    /**
     * gets the user's username
     * @return String username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * get the user's password.
     * @return String password.
     */
    public String getUserPassword() {
        return userPassword;
    }
    /**
     * gets the user's virtual money balance
     * @return 
     */
    public int getVirtualMoney() {
        return virtualMoney;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsActive() {
        return isActive;
    }
}
