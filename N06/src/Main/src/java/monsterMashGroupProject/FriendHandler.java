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

    public String sendRequest(String username, String myName, String server) throws Exception {


        RequestFactory reqFac = new RequestFactory();

        persistIt.init();
        
        if (server.equals("http://localhost:8080/")) {

            Requests requestOther = reqFac.makeIt("FriendRequest", myName, username, server);

            Requests requestUser = reqFac.makeIt("Pending", username, myName, server);

            persistIt.create(requestUser);
            persistIt.create(requestOther);

            persistIt.shutdown();
            
            return "index.jsp";

            
        } else {
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
        }

        persistIt.shutdown();

        return "welcome.jsp";
    }

    /**
     * Allows a user to accept a sendRequest, sendRequest is removed from
     * sendRequest list and added to friends list.
     *
     * @param requester
     * @param recipient
     */
    public void acceptFriendRequest(Requests request) throws IOException {

        FriendsFactory ff = new FriendsFactory();

        persistIt.init();

        if (request.getIpAddress().equals("http://localhost:8080/")) {

            Friends f = ff.makeIt(request.getUserTo(), request.getFromWho(), request.getIpAddress());
            Friends f2 = ff.makeIt(request.getFromWho(), request.getUserTo(), request.getIpAddress());
            persistIt.create(f);
            persistIt.create(f2);

        } else {
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

        }
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
