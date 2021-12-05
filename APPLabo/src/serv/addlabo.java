/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;
import classes.Labo;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import classes.Region;



@WebServlet(name = "addlabo", urlPatterns = {"/addlabo"})
public class addlabo extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        int id_region = Integer.parseInt(request.getParameter("region"));
        String mdp = request.getParameter("mdp");
        Labo l= new Labo();
        l.setNom(nom);
        l.setEmail(email);
        l.setId_region(id_region);
        l.setLogin(login);
        l.setMdp(mdp);
       Client client = ClientBuilder.newClient();
       Response bal = client.target("http://localhost:3001/api/labo")
                   .request(MediaType.APPLICATION_JSON)
                   .post(Entity.entity(l, MediaType.APPLICATION_JSON));
        response.sendRedirect("/EnterpriseApplication4-war/ajouterlab.jsp");

       
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               Client client = ClientBuilder.newClient();
               System.out.println("je suis la");
       List<Region> regions = client.target("http://localhost:3001/api/region")
                            .request(MediaType.APPLICATION_JSON).get(List.class);
       System.out.println(regions);
        HttpSession session = request.getSession();
        session.setAttribute("regions",regions);
        //RequestDispatcher dispatcher =request.getRequestDispatcher("/ajouterlab.jsp");
        //dispatcher.forward(request, response);
        
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
