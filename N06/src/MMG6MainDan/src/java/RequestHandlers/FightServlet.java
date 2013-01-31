package RequestHandlers;

import databaseManagement.Monster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jsonDeSerializers.FightResponse;
import monsterMashGroupProject.Fight;
import com.google.gson.*;
import databaseManagement.PersistManager;
import java.util.List;

/**
 *
 * @author Arom
 */
@WebServlet(name = "FightServlet", urlPatterns = {"/FightServlet"})
public class FightServlet extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String enemyAge = request.getParameter("age");
        String enemyAggression = request.getParameter("aggr");
        String enemyStrength = request.getParameter("str");
        String monsterName = request.getParameter("name");
        int eAge = Integer.parseInt(enemyAge);
        int eStr = Integer.parseInt(enemyStrength);
        int eAggr = Integer.parseInt(enemyAggression);
        Fight fight = new Fight();
        Monster enemy = new Monster();
        enemy.setAge(eAge);
        enemy.setStrength(eStr);
        enemy.setAggression(eAggr);
        PersistManager persistIt = new PersistManager();
        persistIt.init();
        List<Monster> monsters = persistIt.searchMonsters();
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getName().equals(monsterName)) {
                Monster myMonster = new Monster();
                myMonster.setAge(monsters.get(i).getAge());
                myMonster.setStrength(monsters.get(i).getStrength());
                myMonster.setAggression(monsters.get(i).getAggression());
                if (fight.determineWinner(myMonster, enemy).equals(myMonster)) {
                    //Local(challenged) monster wins
                    FightResponse fightResponse = new FightResponse(monsters.get(i).getWorth(), 1);
                    out.print(gson.toJson(fightResponse));
                    //Send money/whatever
                } else {
                    FightResponse fightResponse = new FightResponse(monsters.get(i).getWorth(), 0);
                    out.print(gson.toJson(fightResponse));
                 
                    persistIt.remove(monsters.get(i));
                    //Kill local monster
                }
                
            }
        }
//        Monster myMonster = new Monster();
//        myMonster.setAge(55);
//        myMonster.setStrength(222);
//        myMonster.setAggression(50);

        
        
    }
}
