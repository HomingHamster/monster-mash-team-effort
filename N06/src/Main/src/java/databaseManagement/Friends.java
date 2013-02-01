/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jamesslater
 */
@Entity
public class Friends {
    
    
    @Id
    @GeneratedValue
    private int Id;
    private String friendUsername;
    private String url;
    private String myUser;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMyUser() {
        return myUser;
    }

    public void setMyUser(String myUser) {
        this.myUser = myUser;
    }
    
    
    
    
}
