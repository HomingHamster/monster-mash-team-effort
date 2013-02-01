/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

/**
 * Contains methods related to creating a user. Entity classes cannot have
 * initialiser methods, thus a factory class must be made to create new users quickly.
 * @author Dan
 */
public class UserFactory {
     
        /**
     * Created a user from given parameters.
     * @param name
     * @param password
     * @param virtualMoney
     * @return MyUser new user.
     */
    public static MyUser makeIt(String name, String password, int virtualMoney) {
        MyUser newUser = new MyUser();
        newUser.setUsername(name);
        newUser.setUserPassword(password);
        newUser.setVirtualMoney(virtualMoney);
        return newUser;
    }
   
}
