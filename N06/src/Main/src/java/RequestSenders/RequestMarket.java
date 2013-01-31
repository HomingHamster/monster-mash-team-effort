/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestSenders;

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
public class RequestMarket {

    private static void main() {
    }

    public static void sendMarketRequest(/* Probably URL here*/) throws Exception {
        Gson gson = new Gson();         //Gson object for deserialization of the response
        URL url = new URL("http://193.60.15.159:8080/MMG6Main/MarketHandler");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("");
        writer.flush();
        String line;            //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            /*
             * Monsters are received in ArrayList I guess
             * Gson is deserialized onto the class
             * Monsters added to the db or just displayed(quicker)
             */
            //       Monster monster = gson.fromJson(line, Monster.class);
        }

        writer.close();
        reader.close();
    }
}
