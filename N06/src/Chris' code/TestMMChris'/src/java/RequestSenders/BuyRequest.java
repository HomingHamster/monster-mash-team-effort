/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package requestsenders;

import com.google.gson.Gson;
import databaseManagement.Monster;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Arom
 */
public class BuyRequest {

    private static void main(String[] args) {
    }

    public static void sendFightRequest(String monsterName) throws Exception {
        Gson gson = new Gson(); //Gson object for deserialization of the response
        URL url = new URL("http://193.60.15.159:8080/TestMM/BuyServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("name=" + monsterName);
        writer.flush();
        String line; //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            /*
             * Monster is received Gson is deserialized onto the class Monster
             * needs to be added to the DB
             */
            Monster monster = gson.fromJson(line, Monster.class);
            /*
             * New monster properties can be easily accessed. Add the monster to
             * the database of the user that bought it
             */

        }

        writer.close();
        reader.close();
    }
}