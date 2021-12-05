<%-- 
    Document   : consultelistepatient
    Created on : 17 janv. 2021, 11:37:42
    Author     : asus
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<jsp:include page="/consultelistpat" />-->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <% 
    Date aujourdhui= new Date(); 
   DateFormat  formater = new SimpleDateFormat("dd-MM-yy");
   String now =formater.format(aujourdhui);
  

%>

<!DOCTYPE html>
<%--
<c:if test="${session.Scope.id == null}" >
    <c:redirect url="/loginadmin.jsp" ></c:redirect>
</c:if>
--%>

    <c:if test="${sessionScope.id==null}">
     <c:redirect url="/login.jsp" ></c:redirect>
    </c:if>
<html lang="en">
<head>
<title>Laboratoire</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Laboratoire</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      </ul>
    </li>
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>

<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch--> 

<!--sidebar-menu-->

<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-list"></i></a>
  <ul>
     <li><a href="index.html"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li> <a href="ajoutpat.jsp"><i class="icon icon-signal"></i> <span>Ajouter Patient</span></a> </li>
    <li class="submenu active"> <a href="consultelistepatient.jsp"><i class="icon icon-list"></i><span>Consulter liste Patient</span></a>
    <ul>
        <li><a href="consultelistepatient.jsp">Modifier Patient</a></li>
        <li><a href="consultelistepatient.jsp">Supprimer Patient</a></li>
        <li><a href="consultelistepatient.jsp">Ajouter Résultat</a></li>
        <li><a href="consultelistepatient.jsp">Consulter Résultat</a></li>
      </ul></li>
    
  </ul>
</div>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Liste des Patients</a> </div>
    <h1>Liste des Patients</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
         
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Liste des Patients</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>CIN</th>
                  <th>Nom & Prénom</th>
                  <th>Email</th>
                  <th>Sexe</th>
                  <th>Région</th>
                  <th>Résultat</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="patient" items="${listepatients}" >
                <tr class="gradeX">
                  <td><c:out value="${patient.cin}" /></td>
                  <td><c:out value="${patient.nom}" /> <c:out value="${patient.prenom}" /></td>
                  <td><c:out value="${patient.email}" /></td>
                  <td class="center"><c:out value="${patient.sexe}" /></td>
                  <%@taglib prefix="sql"
                    uri="http://java.sun.com/jsp/jstl/sql"%>
                  <sql:setDataSource var="connexionBdDIssatIntranet"
                    driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/corona?serverTimezone=UTC"
                    user="root" password="root"/>
                 <sql:query dataSource="${connexionBdDIssatIntranet}"
                var="result"> SELECT * from region where id = ${patient.id_region};
                </sql:query>
                <c:forEach items="${result.rows}" var="region"  >
                  <td class="center"><c:out value="${region.nom}" /></td>
                 </c:forEach>
                 <td class="taskOptions"><a href="positif?id=${patient.id_pat}" class="tip-top" data-original-title="Positif"><button><i class="icon-ok" style="color:green"></i></button></a> <a href="negatif?id=${patient.id_pat}" class="tip-top" data-original-title="Négatif"><button><i class="icon-remove" style="color:red"></i></button></a></td>
               
                  <td class="taskOptions">
                      <a href="modifierpat?id=${patient.id_pat}"> <button class="tip"  title="Modifier"><i class="icon-pencil"></i></button></a>
                      <button class="sTrash" onclick="supprimer(${patient.id_pat})" data-target="#myAlert" data-toggle="modal" title="Supprimer"><i class="icon-trash"></i></button>
                      <a href="consulterslt?id=${patient.id_pat}"><button title="consulter resultat"><i class="icon-list-alt"></i></button></a>
                     
              
              <div id="myAlert" class="modal hide">
                  <form method="post" action="consultelistpat?action=supprimer" >
              <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button">×</button>
                <h3>Confirmation de Suppression</h3>
              </div>
              <div class="modal-body">
                <p>Voulez cous supprimer ce patient?</p>
                <input type="hidden" name="id" id="id" />
              </div>
              <div class="modal-footer"> <input  class="btn btn-primary"value="Supprimer" type="submit"> <a data-dismiss="modal" class="btn" href="#">Annuler</a> </div>
                  </form>
              </div>
              
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<c:if test="${message}" >
<script>    
    alert("resultat positif");
</script>
</c:if>>
<script type="text/javascript">
   function supprimer(id){
       document.getElementById("id").value=id;
       
   }
   function consulter(id){
       document.getElementById("id").value= id;
         
   }
   function modifier(id){
       document.getElementById("id").value= id;
   }
   
  
    
</script>
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>

