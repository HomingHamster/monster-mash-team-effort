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
public class BreedRequest {
 public static void main(String[] args) throws Exception {    
        /*
         * Get the monster that needs to be sent ; O
         */
     Monster monster = new Monster();
        monster.setAggression(20);
        monster.setAge(20);
        monster.setStrength(30);
        monster.setHeight(40);
        String newName = "SomeKid";
        String remoteName = "Fred";
        sendBreedRequest(monster.getAggression(), monster.getAge(), monster.getStrength(), monster.getHeight(), newName, remoteName);
        
    }
      public static void sendBreedRequest(int height, int aggression, int str, int age, String newName, String remoteMonster) throws Exception {
        Gson gson = new Gson();         //Gson object for deserialization of the response
        URL url = new URL("http://193.60.15.159:8080/MMG6Main/BreedServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("aggr="+aggression+"&"+"height="+height+"&"+"str="+str+"&"+"age="+age+"&"+"name="+newName+"&"+"remoteName="+remoteMonster);
        writer.flush();
        String line;            //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            /*
             * Gson is deserialized onto the class
             */
           // FightResponse result = gson.fromJson(line, FightResponse.class);
            /*
             * Check the response for the fight result.
             */
            System.out.println(line);

        }

        writer.close();
        reader.close();
    }
}
