package ws;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import serv.NewServlet;


public class selectionWS {

	//noDatetimeStringSync=true
	
	 public List resultat() {
         String url="jdbc:mysql://localhost/corona?serverTimezone=UTC";
       String user = "root";
       String pass = "root";
       Connection connexion = null;
       ResultSet resultSet = null;
        int n = 0 ;
           String nom= null ;
          ArrayList<Object> list = new ArrayList<Object>();
        try{
           java.sql.Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user,pass);
            java.sql.Statement smt = conn.createStatement();
            String req = "select count(*) as nb , r.nom as nom from resultat rslt , patient p , region r "
                    + "where rslt.id_patient = p.id_pat and p.id_region = r.id and rslt.etat = 'Positif'"
                    + " group by r.nom";
            try {
                resultSet =smt.executeQuery(req);
                try {
                while(resultSet.next()){
                   n = Integer.parseInt(resultSet.getString("nb"));
                    nom = resultSet.getString("nom");
                    list.add(n);
                    list.add(nom);
                    
                    
                }
                System.out.println("list show ws :"+list);
                  for(Iterator it=list.iterator(); it.hasNext();){
                    System.out.println(it.next());
                    }
               // System.out.println("<h1>Servlet NewServlet at " + list.get(0)+ "</h1>");
            } catch (SQLException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            } catch (SQLException exp) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, exp);
            }
         
            }catch (Exception ex) {
               System.out.println();
        }
        return list;
        }
}
