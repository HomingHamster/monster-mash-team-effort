/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

/**
 *
 * @author jamesslater
 */
public class FriendsFactory {
    
    public Friends makeIt(String myUsername, String friendUsername, String url) {
        Friends friend = new Friends();
        
        friend.setMyUser(myUsername);
        friend.setFriendUsername(friendUsername);
        friend.setUrl(url);
        
        return friend;
    }
}
