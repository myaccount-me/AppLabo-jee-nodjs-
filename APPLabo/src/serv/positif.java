/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classes.Resultat;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author asus
 */
@WebServlet(name = "positif", urlPatterns = {"/positif"})
public class positif extends HttpServlet {
/*
    @EJB
    private StatFacadeLocal statFacade;

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
        System.out.println("idddd patient:"+id_patient);
        Date aujourdhui= new Date(); 
        //int idlab = 1 ;
         HttpSession session = request.getSession();
        //String idlab =  (String) session.getAttribute("id");
         //System.out.println("labo id:"+Integer.parseInt(idlab));
      String idlab = (String) session.getAttribute("id");
      int id =Integer.parseInt(idlab);
      //System.out.println("labo id:"+Integer.parseInt(idlab));
        Resultat rslt = new Resultat(id,id_patient,aujourdhui,"Positif");
          Client client = ClientBuilder.newClient();
           client
              .target("http://localhost:3001/api/resultatTest")
               .request(MediaType.APPLICATION_JSON)
               .post(Entity.entity(rslt, MediaType.APPLICATION_JSON));
       // System.out.println("ajout succéeeees!!!!"+client);
       /*  Client client1 = ClientBuilder.newClient();
          List stat = client1.target("http://localhost:3001/api/stat")
                         .request(MediaType.APPLICATION_JSON).get(List.class);
           //    String[] arrSplit = stat.get(0).toString().split(",");
      //  String[] arrSplit1 = arrSplit[0].split("=");
      //  System.out.println("my list stat split:" +arrSplit1[1]);
          for (int i=0 ; i<stat.size(); i++){
               String[] arrSplit = stat.get(i).toString().split(",");
        String[] arrSplit1 = arrSplit[0].split("=");
        String[] arrSplit2 = arrSplit[1].split("=");
         System.out.println("my nom region: "+Arrays.toString(arrSplit2[1].split("}")).toString());
             System.out.println("my stat elt: "+arrSplit1[1]); 
             System.out.println("my stat elt: "+arrSplit2[1]); 
             
          }
          System.out.println("my stat resultat is here: "+stat);*/
      response.sendRedirect(request.getContextPath() + "/consulterslt?id="+id_patient);
      
      
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
        processRequest(request, response);
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
