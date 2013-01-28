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

    public Login(User user) {
        persistIt.init();
        List<User> users = persistIt.searchUsers();
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i).getName().equals(user.getName())) && (users.get(i).getPassword().equals(users.get(i).getPassword()))) {
                user.setLoggedIn(true);
            }
        }
        persistIt.shutdown();
    }

    public void Register(String name, String password) {
        PatternSyntaxException exc = null;

        if ((matches(REGEX, name) == true) && (matches(REGEX, password) == true)) {
            persistIt.init();
            persistIt.create(UserFactory.makeIt(name, password, 100));

        }
        persistIt.shutdown();
    }

    public boolean matches(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
