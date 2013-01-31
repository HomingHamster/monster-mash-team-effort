/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

import databaseManagement.MyUser;
import databaseManagement.PersistManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arom
 */
@WebServlet(name = "FriendshipServlet", urlPatterns = {"/FriendshipServlet"})
public class FriendshipServlet extends HttpServlet {

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
        //    processRequest(request, response);
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
        String requestedUser = request.getParameter("username");
        String fromUser = request.getParameter("localUser"); 

        PersistManager persistIt = new PersistManager();
        persistIt.init();
        List<MyUser> users = persistIt.searchUsers();
     
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUsername().toString().equals(requestedUser)) {
                //Send friendship request
                //If accepted
                out.print("Accepted");
            }
        }
    }
}
