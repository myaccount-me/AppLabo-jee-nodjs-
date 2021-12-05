/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;
import serv.patient;
import classes.Region;
/**
 *
 * @author asus
 */
@WebServlet(name = "addpatient", urlPatterns = {"/addpatient"})
public class addpatient extends HttpServlet {

  

    
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               Client client = ClientBuilder.newClient();
       List<Region> regions = client.target("http://localhost:3001/api/region")
                            .request(MediaType.APPLICATION_JSON).get(List.class);
        HttpSession session = request.getSession();
        session.setAttribute("regions",regions);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        int cin = Integer.parseInt(request.getParameter("cin"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int tel = Integer.parseInt(request.getParameter("tel"));
       DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date date=null;
        try {
            date = format.parse(request.getParameter("dnaiss"));
        } catch (ParseException ex) {
            Logger.getLogger(addpatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        String email = request.getParameter("email");
       String sexe = request.getParameter("sexe");
        int reg = Integer.parseInt(request.getParameter("reg"));
       
        patient p = new patient();
        p.setCin(cin);
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setSexe(sexe);
        p.setTelephone(tel);
        p.setDnaiss(date);
        p.setEmail(email);
        p.setId_region(reg);
        
        Client client = ClientBuilder.newClient();
       Response bal = client.target("http://localhost:3001/api/Resultat")
                   .request(MediaType.APPLICATION_JSON)
                   .post(Entity.entity(p, MediaType.APPLICATION_JSON));
        response.sendRedirect("/EnterpriseApplication4-war/ajoutpat.jsp");
        
       
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
