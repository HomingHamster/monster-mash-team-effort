/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

import databaseManagement.*;
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
 * @author cki
 */
@WebServlet(name = "AcceptFriendship", urlPatterns = {"/AcceptFriendship"})
public class AcceptFriendship extends HttpServlet {

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
            out.println("<title>Servlet AcceptFriendship</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcceptFriendship at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);

        String acceptButton = request.getParameter("acceptbtn");
        String declineButton = request.getParameter("declinebtn");
        String fromWho = request.getParameter("name");
        String id = request.getParameter("reqID");
        String address = request.getRemoteAddr();

        //   int reqID = Integer.parseInt(id);

//        if(acceptButton.equals("Accept")){

        PersistManager persistIt = new PersistManager();
        RequestFactory reqFac = new RequestFactory();
        FriendsFactory ff = new FriendsFactory();
        persistIt.init();

        List<Requests> requests = persistIt.searchRequets();
        if (acceptButton.equals("Accept")) {
            for (int i = 0; i < requests.size(); i++) {

                Integer req = requests.get(i).getId();
                String param = req.toString();

                if (param.equals(id)) {

                    Friends f = ff.makeIt(requests.get(i).getUserTo(), fromWho, address);
                    Friends f2 = ff.makeIt(fromWho, requests.get(i).getUserTo(), address);
                    persistIt.create(f);
                    persistIt.create(f2);

                    persistIt.remove(requests.get(i));

                }

            }
        } else {
            for (int i = 0; i < requests.size(); i++) {

                Integer req = requests.get(i).getId();
                String param = req.toString();

                if (param.equals(id)) {
                    persistIt.remove(requests.get(i));
                }
            }
        }
        response.sendRedirect("welcome.jsp");
        persistIt.shutdown();
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
