/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.PersistManager;
import databaseManagement.Requests;

/**
 *
 * @author jamesslater
 */
public class RequestController {
    
    PersistManager persistIt = new PersistManager();
    
    public String controller(String requestID, String choice){
        
        if ((choice.equals("FriendRequest"))&&(requestID.equals("acceptbtn"))){
            
        }
        
        return "welcome.jsp";
    }
    
    
    /**
     * Allows the user to reject a sendRequest, sendRequest is removed from
     * sendRequest list, requester is not alerted.
     *
     * @param requester
     * @param recipient
     */
    public void rejectRequest(Requests request) {
        persistIt.init();
        
        persistIt.remove(request);
        
        persistIt.shutdown();
        
    }
    
}
