/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package requestsenders;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;

/**
 *
 * @author Arom
 */
public class RequestFriendship {

    private static void main(String[] args) throws Exception {
        request("Aaa", "http://localhost:8080/TestMM/");
//If accepted
//Add to friends list
//if rejected
//Inform abour rejection
//else
//Do nothing(i.e wait, you'll have no friends, dat Comp Sci fate)

    }

    public static void request(String username, String server) throws Exception {
//Personal message?

        URL url = new URL(server + "FriendshipServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("username=" + username);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        writer.close();
        reader.close();
    }
}