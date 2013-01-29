/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

import databaseManagement.Monster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monsterMashGroupProject.Fight;
import com.google.gson.*;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String enemyAge = request.getParameter("age");
        String enemyAggression = request.getParameter("aggr");
        String enemyStrength = request.getParameter("str");
        int eAge = Integer.parseInt(enemyAge);
        int eStr = Integer.parseInt(enemyStrength);
        int eAggr = Integer.parseInt(enemyAggression);
        Fight fight = new Fight();
        Monster enemy = new Monster();
        enemy.setAge(eAge);
        enemy.setStrength(eStr);
        enemy.setAggression(eAggr);
        /*
         * This is where the code for asking the user about the fight is needed
         * If he agrees do the below - Get his monster from the DB etc Else send
         * fight rejected or some shit.
         */
        Monster myMonster = new Monster();
        myMonster.setAge(55);
        myMonster.setStrength(222);
        myMonster.setAggression(50);
        Gson gson = new Gson();

        if (fight.determineWinner(myMonster, enemy).equals(myMonster)) {
            //Local(challenged) monster wins
            FightResponse fightResponse = new FightResponse(200, 0);
            out.print(gson.toJson(fightResponse));
            //Send money/whatever
        } else {
            //Enemy monster wins
            FightResponse fightResponse = new FightResponse(20, 1);
            out.print(gson.toJson(fightResponse));
            //Kill local monster
        }

    }
}
