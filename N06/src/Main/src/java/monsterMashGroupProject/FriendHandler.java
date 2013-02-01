/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Contains methods that relate to the list of friends each user has.
 *
 * @author Dan
 */
public class FriendHandler {

    private PersistManager persistIt = new PersistManager();

    public void sendRequest(String username, String myName, String server) throws Exception {
        //Personal message?

        URL url = new URL(server + "FriendshipServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("username=" + username + "&" + "localUser=" + myName);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
        }


        reader.close();
        writer.close();

        persistIt.init();

        RequestFactory reqFac = new RequestFactory();

        Requests request = reqFac.makeIt("Pending", username, myName, server);

        persistIt.create(request);

        persistIt.shutdown();
    }

    /**
     * Allows a user to accept a sendRequest, sendRequest is removed from
     * sendRequest list and added to friends list.
     *
     * @param requester
     * @param recipient
     */
    public void acceptFriendRequest(Requests request) throws IOException {
        persistIt.init();

        URL url = new URL(request.getIpAddress() + "FriendshipServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("username=" + request.getFromWho() + "&" + "localUser=" + request.getUserTo());
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
        }

        reader.close();
        writer.close();
        
        FriendsFactory ff = new FriendsFactory();
        Friends f = ff.makeIt(request.getUserTo(), request.getFromWho(), request.getIpAddress());
        persistIt.create(f);
        persistIt.remove(request);
        persistIt.shutdown();
    }

    /**
     * Allows the user to remove a friend. The friend is removed from the users
     * friends list, the user is also removed from the friends friends list.
     *
     * @param user
     * @param friend
     */
    public void removeFriend(Friends friend) {
        persistIt.init();
        
        persistIt.remove(friend);
        
        persistIt.shutdown();
        
    }
}
