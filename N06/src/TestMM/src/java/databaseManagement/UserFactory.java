/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

/**
 *
 * @author Dan
 */
public class UserFactory {
     
    
    public static User makeIt(String name, String password, int virtualMoney) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setVirtualMoney(virtualMoney);
        return newUser;
    }
   
}
