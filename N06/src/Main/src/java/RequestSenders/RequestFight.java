/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestSenders;

import jsonDeSerializers.FightResponse;
import databaseManagement.*;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Arom
 */
public class RequestFight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
         * Example code for testing.
         * Creates a monster and sends it through the method.
         */
        Monster monster = new Monster();
        monster.setAggression(10);
        monster.setStrength(10);
        monster.setAge(110);
//        PersistManager persistIt = new PersistManager();
//
//        persistIt.init();
        String enemy = "Fred";
        String enemyOwner = "sd";
        sendFightRequest(monster.getAggression(), monster.getStrength(), monster.getAge(), enemy, "sd", enemyOwner);

    }

    public static void sendFightRequest(int aggression, int str, int age, String enemy, String thisUser, String toUser) throws Exception {
        Gson gson = new Gson();         //Gson object for deserialization of the response
     URL url = new URL("http://localhost:8080/Main/FightServlet");
      //  URL url = new URL("http://192.168.43.75:8080/MonsterMash/FightServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("aggr=" + aggression + "&"
                + "str=" + str + "&" 
                + "age=" + age + "&" 
                + "name=" + enemy+"&"
                +"remoteUser="+thisUser+"&"
                +"thisUser="+toUser);
        writer.flush();
        String line;            //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
//            /*
//             * Gson is deserialized onto the class
//             */
//            FightResponse result = gson.fromJson(line, FightResponse.class);
//            /*
//             * Check the response for the fight result.
//             */
//            
//            if (result.getResult()==0) {
//                //Inform the user about the win
//                System.out.println("You have won! Your reward is " + result.getMoney());
//                //Grant him money
//            } else {
//                //Inform the user about the loss
//                System.out.println("You have lost, your monster is dead!");
//                //Kill the monster in front of his eyes.
//            }

        }

        writer.close();
        reader.close();
    }
}
