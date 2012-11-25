/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.persistence.*;

/**
 * Persistable User object. name = primary key.
 * Tags make it work and come with the hibernate library, they will not work without it.
 * @author Dan
 */
@Entity
public class User {
    @Id
    private String name;
    private String password;
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
