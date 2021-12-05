/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classes.Admin;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
//import jpa.Region;

/**
 *
 * @author hp
 */
@WebServlet(name = "connexionAdmin", urlPatterns = {"/connexionAdmin"})
public class connexionAdmin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     request.getSession().invalidate();
     response.sendRedirect("/APPLabo/loginadmin.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
                       Client client = ClientBuilder.newClient();
       List res = client.target("http://localhost:3001/api/admin?login="+login+"&mdp="+mdp)
                            .request(MediaType.APPLICATION_JSON).get(List.class);
        //List <Admin> res=adminFacade.Connexion(login, mdp);
        if(res.isEmpty()){
            response.sendRedirect("/APPLabo/loginadmin.jsp");
        }else{
            response.sendRedirect("/APPLabo/ajouterlab.jsp");
            HttpSession session = request.getSession();
        String[] arrSplit = res.get(0).toString().split(",");
        String[] arrSplit1 = arrSplit[0].split("=");
            session.setAttribute("idA",arrSplit1[1]);
        }
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
