/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author dam44
 */
public class Login {

    PersistManager persistIt = new PersistManager();
    private static final String REGEX = "([0-9a-zA-Z_-!?@]+)";
    private String username;
    private String password;
    public MyUser user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String LoginUser() {
        persistIt.init();
        List<MyUser> users = persistIt.searchUsers();
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i).getUsername().equals(username)) && (users.get(i).getUserPassword().equals(password))) {
               user= users.get(i); 
                
                return "welcome.jsp";
            }
        }
        persistIt.shutdown();
        return "index.jsp";
    }

    public String Register(String name, String password, String email) {
        persistIt.init();
        //if ((matches(REGEX, name.toString()) == true) && (matches(REGEX, password.toString()) == true)) {
        MyUser myUser = UserFactory.makeIt(name, password, 100);
        
        persistIt.create(myUser);

        //}
        persistIt.shutdown();
        return "index.jsp";
    }

    public boolean matches(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
