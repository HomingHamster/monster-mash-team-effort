/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonDeSerializers;

/**
 *
 * @author Arom
 */
public class FriendshipResponse {
 String localUser, remoteUser;

    public String getLocalUser() {
        return localUser;
    }

    public void setLocalUser(String localUser) {
        this.localUser = localUser;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }
 
    FriendshipResponse(String local, String remote){
       local = this.localUser;
       remote = this.remoteUser;
    }
}
