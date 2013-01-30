/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.util.ArrayList;
import java.util.List;
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
    private boolean isLoggedIn;
    private boolean isActive;
    private int virtualMoney;
    @OneToMany
    private List<MyUser> friends;

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

<<<<<<< HEAD
=======
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

>>>>>>> Updated
    public void setFriends(List<MyUser> friends) {
        this.friends = friends;
    }

    public List<MyUser> getFriends() {
        return friends;
    }
}
