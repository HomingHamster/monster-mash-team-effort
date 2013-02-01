package RequestHandlers;

import com.google.gson.Gson;
import databaseManagement.Monster;
import databaseManagement.PersistManager;
import databaseManagement.RequestFactory;
import databaseManagement.Requests;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arom
 */
@WebServlet(name = "BreedServlet", urlPatterns = {"/BreedServlet"})
public class BreedServlet extends HttpServlet {

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
            out.println("<title>Servlet BreedServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BreedServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String aggression = request.getParameter("aggr");
        String age = request.getParameter("age");
        String strength = request.getParameter("str");
        String height = request.getParameter("height");
        String newName = request.getParameter("name");
        String localName = request.getParameter("remoteName");
        String from = request.getParameter("fromWho");
        String to = request.getParameter("toWho");
        String url = request.getRemoteAddr();

        int eAggr = Integer.parseInt(aggression);
        int eStr = Integer.parseInt(strength);
        int eHeight = Integer.parseInt(height);
        int eAge = Integer.parseInt(age);

        Monster enemyMonster = new Monster();
        enemyMonster.setAggression(eAggr);
        enemyMonster.setStrength(eStr);
        enemyMonster.setHeight(eHeight);
        enemyMonster.setAge(eAge);

        PersistManager persistIt = new PersistManager();
        persistIt.init();
        RequestFactory rf = new RequestFactory();
        Requests addRequest = rf.makeIt("Breed", to, from, url);
        persistIt.create(addRequest);

        
        

//        List<Monster> monsters = persistIt.searchMonsters();
//        for (int i = 0; i < monsters.size(); i++) {
//            if (monsters.get(i).getName().equals(localName)) {
//                Breed breed = new Breed();
//             //   out.print(gson.toJson(breed.breedMonsters(enemyMonster, monsters.get(i), newName, "sd")));
//               
//
//            }
//        }




    }
}
