/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import monsterMashGroupProject.UserEmail;
        
/**
 * Class contains methods relating to registering
 * new users.
 * @author jamesslater
 */
public class RegisterInfo {
    
    private String regUsername;
    
    private String regPassword;
    
    private String regEmail;

    /**
     * Gets current username
     * @return String username.
     */
    public String getRegUsername() {
        return regUsername;
    }

    /**
     * sets current username.
     * @param regUsername 
     */
    public void setRegUsername(String regUsername) {
        this.regUsername = regUsername;
    }

    /**
     * gets current password.
     * @return String password
     */
    public String getRegPassword() {
        return regPassword;
    }

    /**
     * sets a new current password.
     * @param regPassword 
     */
    public void setRegPassword(String regPassword) {
        this.regPassword = regPassword;
    }

    /**
     * Gets current email.
     * @return String email.
     */
    public String getRegEmail() {
        return regEmail;
    }

    /**
     * sets current email.
     * @param regEmail 
     */
    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }
    
    /**
     * adds current user to the system.
     * @return String page to redirect to.
     */
    public String addUser(){
        Login log = new Login();
        
        log.Register(regUsername, regPassword, 
                regEmail);
        
        UserEmail email = new UserEmail();
        email.send("felix.farquharson@googlemail.com", "monster-mash-n06@teame4t.co.uk",
                "User Registration", "Sucessfully registered");
        
        return "index.jsp";
    }
    
}
