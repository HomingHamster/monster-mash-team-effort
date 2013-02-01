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
import java.util.ArrayList;

/**
 *
 * @author Arom
 */
public class RequestUserMonsters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        getUserMonstersRequest("sd");
    }

    public static void getUserMonstersRequest(String username) throws Exception {
        Gson gson = new Gson();         //Gson object for deserialization of the response
        URL url = new URL("http://localhost:8080/Main/GetUserMonstersServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("username=" + username);
        writer.flush();
        String line;            //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            /*
             * Gson is deserialized onto the class
             */
            ArrayList monsters = gson.fromJson(line, ArrayList.class);
            int many = monsters.size();
            System.out.println("User " + username + " has " + many + " monsters");
            for (int i = 0; i < monsters.size(); i++) {
                String a = gson.toJson(monsters.get(i));
                Monster m = gson.fromJson(a, Monster.class);
                System.out.println(m.getName());
                System.out.println("Strength " + m.getStrength());
                System.out.println("Age " + m.getAge());
                System.out.println("Aggression " + m.getAggression());
            }


        }



        writer.close();
        reader.close();
    }
}
