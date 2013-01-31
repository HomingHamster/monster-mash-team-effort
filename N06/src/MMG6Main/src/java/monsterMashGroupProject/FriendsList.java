/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;

/**
 * Contains methods that relate to the list of friends
 * each user has.
 * @author Dan
 */
public class FriendsList {

    PersistManager persistIt = new PersistManager();

    /**
     * Adds a friend to a user.
     * @param user
     * @param friend 
     */
    public void addFriend(MyUser user, MyUser friend) {
        persistIt.init();
        user.getFriends().set(user.getFriends().size(),
                friend);
        //user.setIsActive(true);
        persistIt.update(user);
        persistIt.shutdown();
    }

    /**
     * Removes a user's friend.
     * @param user
     * @param friend 
     */
    public void removeFriend(MyUser user, 
            MyUser friend) {
        persistIt.init();
        for (int i = 0; i < user.getFriends().size();
                i++) {
            if (user.getFriends().get(i).getUsername()
                    .equals(friend.getUsername())) {
                user.getFriends().remove(i);
            }
        }
        //user.setIsActive(true);
        persistIt.update(user);
        persistIt.shutdown();
    }
}
