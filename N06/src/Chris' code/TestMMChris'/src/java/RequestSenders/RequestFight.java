
import RequestHandlers.FightResponse;
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
public class RequestFight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
         * Example code for testing. Creates a monster and sends it through the
         * method.
         */
        Monster monster = new Monster();
        monster.setAggression(43);
        monster.setStrength(120);
        monster.setAge(50);

        sendFightRequest(monster.getAggression(), monster.getStrength(), monster.getAge());

    }

    public static void sendFightRequest(int aggression, int str, int age) throws Exception {
        Gson gson = new Gson(); //Gson object for deserialization of the response
        URL url = new URL("http://193.60.15.159:8080/TestMM/FightServlet");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        /*
         * POST request details
         */
        writer.write("aggr=" + aggression + "&" + "str=" + str + "&" + "age=" + age);
        writer.flush();
        String line; //Response in text
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            /*
             * Gson is deserialized onto the class
             */
            FightResponse result = gson.fromJson(line, FightResponse.class);
            /*
             * Check the response for the fight result.
             */
            if (result.getResult().contains("0")) {
//Inform the user about the loss
                System.out.println("You have lost, your monster is dead!");
//Kill the monster in front of his eyes.
            } else {
//Inform the user about the win
                System.out.println("You have won! Your reward is " + result.getMoney());
//Grant him money
            }

        }

        writer.close();
        reader.close();
    }
}