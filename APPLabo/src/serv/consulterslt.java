/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import classes.Resultat;
/**
 *
 * @author asus
 */
@WebServlet(name = "consulterslt", urlPatterns = {"/consulterslt"})
public class consulterslt extends HttpServlet {
/*
    @EJB
    private ResultatFacadeLocal resultatFacade;*/

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id_patient = Integer.parseInt(request.getParameter("id"));
   //      System.out.println("id hereeeee:"+id_patient);
        HttpSession session = request.getSession();
        session.setAttribute("id", id_patient);
        Resultat rslt = new Resultat();
        Client client = ClientBuilder.newClient();
      List<Resultat> resultat =  client.target("http://localhost:3001/api/resultatTest").queryParam("id_patient", id_patient).request(MediaType.APPLICATION_JSON).get(List.class);
      //Response response1 = resultat.get();
       // List<Resultat> value = resultat.readEntity(List.class);
        System.out.println("succées rslt and id hereeeee:"+id_patient+", client: "+resultat);
        session.setAttribute("listeresultats", resultat);
      request.getRequestDispatcher("/consulterslt.jsp").forward(request, response);
        
        
        
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
          int id = Integer.parseInt(request.getParameter("id"));
          int idpat = Integer.parseInt(request.getParameter("idpat"));
       Client client = ClientBuilder.newClient();
       Response res = client.target("http://localhost:3001/api/resultatTest/"+id)
               .request(MediaType.APPLICATION_JSON)
               .delete();
         // processRequest(request, response);
        response.sendRedirect("http://localhost:8086/EnterpriseApplication4-war/consulterslt.jsp?id="+idpat);
            
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
