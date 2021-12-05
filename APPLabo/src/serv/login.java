/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

  /*  @EJB
    private LaboFacadeLocal laboFacade;*/


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addpatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addpatient at hiiiiiii </h1>");
            out.println("</body>");
            out.println("</html>");
        }
        /**
        int rslt = laboFacade.login(login, mdp);
        if( rslt > 0 ){
            request.getRequestDispatcher("/index.html").forward(request, response);
             try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addpatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addpatient at " + rslt + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        }
       */
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
