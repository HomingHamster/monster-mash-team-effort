/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;

/**
 *
 * @author Dan
 */
public class FriendsList {

    PersistManager persistIt = new PersistManager();

    public void addFriend(MyUser user, MyUser friend) {
        persistIt.init();
        user.getFriends().set(user.getFriends().size(), friend);
        //user.setIsActive(true);
        persistIt.update(user);
        persistIt.shutdown();
    }

    public void removeFriend(MyUser user, MyUser friend) {
        persistIt.init();
        for (int i = 0; i < user.getFriends().size(); i++) {
            if (user.getFriends().get(i).getUsername().equals(friend.getUsername())) {
                user.getFriends().remove(i);
            }
        }
        //user.setIsActive(true);
        persistIt.update(user);
        persistIt.shutdown();
    }
}