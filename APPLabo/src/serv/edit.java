/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import classes.Patient;
/**
 *
 * @author asus
 */
@WebServlet(name = "edit", urlPatterns = {"/edit"})
public class edit extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient pat;
        int idpat = Integer.parseInt(request.getParameter("idpat"));
        int cin = Integer.parseInt(request.getParameter("cin")) ;
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        //String dnaiss = request.getParameter("dnaiss");
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date dnaiss=null;
        try {
            dnaiss = format.parse(request.getParameter("dnaiss"));
        } catch (ParseException ex) {
            Logger.getLogger(addpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tel = Integer.parseInt(request.getParameter("tel"));
        String email = request.getParameter("email");
        String sexe = request.getParameter("sexe");
        int reg =  Integer.parseInt(request.getParameter("reg")) ;
        patient p = new patient(idpat, cin, nom, prenom, dnaiss, tel, email, sexe, reg);
      // patientFacade.remove(idpat);
        //patientFacade.edit(pat);
       // response.sendRedirect("/Applabo-war/consultelistepatient.jsp");
       Client client = ClientBuilder.newClient();
        Response bal = client.target("http://localhost:3001/api/Resultat/"+idpat)
                   .request(MediaType.APPLICATION_JSON)
                   .put(Entity.entity(p, MediaType.APPLICATION_JSON));
        //laboFacade.edit(l);
        response.sendRedirect("/EnterpriseApplication4-war/consultelistepatient.jsp");
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
