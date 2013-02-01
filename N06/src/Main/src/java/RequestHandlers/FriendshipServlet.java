/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

import databaseManagement.PersistManager;
import databaseManagement.RequestFactory;
import databaseManagement.Requests;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
        String requestedUser = request.getParameter("friendUsername");
        System.out.println(requestedUser);
        String fromUser = request.getParameter("sessionUser");
        System.out.println(fromUser);
        String url = request.getParameter("servers");
        PersistManager persistIt = new PersistManager();
        persistIt.init();

        RequestFactory factory;
        factory = new RequestFactory();
        
        Requests addRequest = factory.makeIt("friend",  requestedUser,fromUser, url);
        persistIt.create(addRequest);

        response.sendRedirect("welcome.jsp");

    }
}
