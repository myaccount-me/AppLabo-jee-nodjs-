package serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class connexionlabo
 */
@WebServlet("/connexionlabo")
public class connexionlabo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexionlabo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub*
		String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
    	Client client = ClientBuilder.newClient();
        List resultat = client.target("http://localhost:3001/api/Login/labo?login="+login+"&mdp="+mdp)
                             .request(MediaType.APPLICATION_JSON).get(List.class);
        if(resultat.isEmpty()){
            response.sendRedirect("/APPLabo/login.jsp");
        }else{
//getting values form the JSONObject and casting that values into corresponding types  
         String[] arrSplit = resultat.get(0).toString().split(",");
        String[] arrSplit1 = arrSplit[0].split("=");
        System.out.println("my list split:" +arrSplit1[1]);
           HttpSession session = request.getSession();
           session.setAttribute("id",arrSplit1[1]);
           response.sendRedirect(request.getContextPath() + "/consultelistpat");
        }
		doGet(request, response);
	}

}
