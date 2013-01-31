/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

import databaseManagement.Monster;
import databaseManagement.PersistManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

/**
 *
 * @author cki
 */
@WebServlet(name = "GetUserMonstersServlet", urlPatterns = {"/GetUserMonstersServlet"})
public class GetUserMonstersServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetUserMonstersServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetUserMonstersServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        String username = request.getParameter("username");

        PersistManager persistInt = new PersistManager();
        persistInt.init();
        List<Monster> monsters = persistInt.searchMonsters(username); 
        ArrayList<Monster> toSend = new ArrayList<Monster>();
       
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = new Monster();
            monster.setAge(monsters.get(i).getAge());
            monster.setAggression(monsters.get(i).getAggression());
            monster.setStrength(monsters.get(i).getStrength());
            monster.setName(monsters.get(i).getName());
            
            toSend.add(monster);
        }
        out.write(gson.toJson(toSend));
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
