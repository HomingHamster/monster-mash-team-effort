/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestSenders;

import com.google.gson.Gson;
import databaseManagement.Monster;
import databaseManagement.MyUser;
import databaseManagement.PersistManager;
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

    public static void main(String[] args) throws Exception {
        sendBuyRequest("Fred");
    }

    public static void sendBuyRequest(String monsterName) throws Exception {
        Gson gson = new Gson();         //Gson object for deserialization of the response
        URL url = new URL("http://193.60.15.159:8080/MMG6Main/BuyServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("name=" + monsterName);
        writer.flush();
        String line;            //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            Monster monster = gson.fromJson(line, Monster.class);
            System.out.println(monster.getAggression());
            PersistManager persistIt = new PersistManager();
            persistIt.init();
            persistIt.create(monster);
            //Add Monster to the user who sent the request
        }

        writer.close();
        reader.close();
    }
}
