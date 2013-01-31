/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

/**
 *
 * @author jamesslater
 */
public class RequestFactory {

    public static Requests makeIt(String type,
            String userTo,
            String fromWho,
            String ipAddress) {
        
        Requests request = new Requests();
        
        request.setType(type);
        request.setUserTo(userTo);
        request.setIpAddress(ipAddress);
        request.setFromWho(fromWho);
        
        return request;
    }
}
