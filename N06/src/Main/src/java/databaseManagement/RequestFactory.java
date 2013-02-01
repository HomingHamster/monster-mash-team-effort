/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

/**
 *
 * @author jamesslater 
 * Entity classes cannot have
 * initialiser methods, thus a factory class must be made to create new requests quickly.
 */
public class RequestFactory {

    public Requests makeIt(String type,
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
