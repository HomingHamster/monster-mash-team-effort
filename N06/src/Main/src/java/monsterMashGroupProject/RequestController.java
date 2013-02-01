/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.PersistManager;
import databaseManagement.Requests;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jamesslater
 */
public class RequestController {
    
    PersistManager persistIt = new PersistManager();
    
    Requests request;
    
    public String controller(String requestID, String acceptbtn, String declinebtn){
        
        FriendHandler friendHand = new FriendHandler();
        
        persistIt.init();
        
        List<Requests> requestList = persistIt.searchRequets();
        int converted = Integer.parseInt(requestID);
        for(int i = 0; i < requestList.size(); i++){
            if(requestList.get(i).getId()==converted){
                this.request = requestList.get(i);
            }
        }
        
        if (acceptbtn!=null) {
                        
            if (request.getType().equals("FriendRequest")) {
                try {
                    friendHand.acceptFriendRequest(request);
                } catch (IOException ex) {
                    Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (request.getType().equals("BreedingRequest")) {
                //TODO: BreedHandler
            } else if (request.getType().equals("FightRequest")) {
                
            } else if (request.getType().equals("TradeRequest")) {
                
            } else {
                // shouldn't happen
            }
            
        } else {
            
            this.rejectRequest(request);
            
        }
        
//        if ((acceptbtn.equals("Accept")&&(request.getType().equals("FriendRequest")))){
//            try {
//                friendHand.acceptFriendRequest(request);
//            } catch (IOException ex) {
//                Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        return "welcome.jsp";
    }
    
    
    /**
     * Allows the user to reject a sendRequest, sendRequest is removed from
     * sendRequest list, requester is not alerted.
     *
     * @param requester
     * @param recipient
     */
    private void rejectRequest(Requests request) {
        persistIt.init();
        
        persistIt.remove(request);
        
        persistIt.shutdown();
        
    }
    
}
