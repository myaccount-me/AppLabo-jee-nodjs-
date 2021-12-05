/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classes.Patient;
import java.io.IOException;
import java.util.List;

import classes.Resultat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author asus
 */
@WebServlet(name = "consultelistpat", urlPatterns = {"/consultelistpat"})
public class consultelistpat extends HttpServlet {

 /*   @EJB
    private ResultatFacadeLocal resultatFacade;

    @EJB
    private PatientFacadeLocal patientFacade;
  */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   List<Patient> patients = patientFacade.findAll();
    //    String hello;
      Client client = ClientBuilder.newClient();
     List<Patient> patients = client.target("http://localhost:3001/listpatient")
                         .request(MediaType.APPLICATION_JSON).get(List.class);
      System.out.println("my web target  show here baliizz "+patients);
        HttpSession session = request.getSession();
        session.setAttribute("listepatients", patients);
        response.sendRedirect("/APPLabo/consultelistepatient.jsp");
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String action = request.getParameter("action");
      if(action.equals("supprimer")){
          int id = Integer.parseInt(request.getParameter("id"));
         // resultatFacade.removerslt(id);
         //patientFacade.remove(id);
         // response.sendRedirect("/Applabo-war/consultelistepatient.jsp");
         patient p = new patient(id);
        //laboFacade.remove(l);
        Client client = ClientBuilder.newClient();
        Response bal = client.target("http://localhost:3001/api/Resultat/"+id)
                   .request(MediaType.APPLICATION_JSON)
                   .delete();
                   //.post(Entity.entity(l, MediaType.APPLICATION_JSON));
        response.sendRedirect("/EnterpriseApplication4-war/consultelistepatient.jsp");
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
