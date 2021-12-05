<%-- 
   Document   : ajoutpat
    Created on : 16 janv. 2021, 21:55:45
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <c:if test="${session.Scope.id == null}" >
    <c:redirect url="/loginadmin.jsp" ></c:redirect>
</c:if>--%>
<!DOCTYPE html>
 
<html lang="en">
   
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
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
    <li class="active"> <a href="ajoutpat.jsp"><i class="icon icon-signal"></i> <span>Ajouter Patient</span></a> </li>
    <li class="submenu"> <a href="consultelistepatient.jsp"><i class="icon icon-list"></i><span>Consulter liste Patient</span></a>
    <ul>
        <li><a href="consultelistepatient.jsp">Modifier Patient</a></li>
        <li><a href="consultelistepatient.jsp">Supprimer Patient</a></li>
        <li><a href="consultelistepatient.jsp">Ajouter Résultat</a></li>
        <li><a href="consultelistepatient.jsp">Consulter Résultat</a></li>
      </ul></li>
    
  </ul>
</div>

<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a><a href="ajoutpat.jsp" class="current">Ajouter Nouveau Patient</a> </div>
  <h1>Formulaire</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Nouveau Patient</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="addpatient" method="post" class="form-horizontal">
              <div class="control-group">
              <label class="control-label">cin</label>
              <div class="controls">
                <input type="number" class="span11" placeholder="Company name" name="cin" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Nom</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="nom" name="nom" pattern="[a-zA-Z/s]+" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Prénom</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="prenom" pattern="[a-zA-Z/s]+" name="prenom" required/>
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">Date De Naissance</label>
              <div class="controls">
                <input type="text"  data-date-format="dd-mm-yyyy" name="dnaiss" class="datepicker span11" required>
                
            </div>
            <div class="control-group">
              <label class="control-label">telephone</label>
              <div class="controls">
                <input type="text" class="span11" placeholder="telephone" pattern="[0-9]+" name="tel" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">email</label>
              <div class="controls">
                <input type="email" class="span11" placeholder="email" name="email" required/>
              </div>
            </div>
               <div class="control-group">
              <label class="control-label">Sexe</label>
              <div class="controls">
                <label>
                  <input type="radio" name="sexe" value="femme" />
                  Femme</label>
                <label>
                  <input type="radio" name="sexe" value="homme" />
                  Homme</label>
                
              </div>
            </div>
              
               <div class="control-group">
              <label class="control-label">Région</label>
              <div class="controls">
                  
<%@taglib prefix="sql"
uri="http://java.sun.com/jsp/jstl/sql"%>
                  <sql:setDataSource var="connexionBdDIssatIntranet"
                    driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/corona?serverTimezone=UTC"
                    user="root" password="root"/>
                 <sql:query dataSource="${connexionBdDIssatIntranet}"
                var="result"> SELECT * from region;
                </sql:query>
                <select name="reg" required>
                    <c:forEach items="${result.rows}" var="region"  >
                          <option value="${region.id}"> <c:out  value="${region.nom}"/></option>
                      </c:forEach>
                  
                </select>
                         
                 </div>
            </div>
             <div style="margin-left: 200px;">
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Save</button>
            </div>
             </div>
          </form>
        </div>
      </div>
     
      
    </div>
   
      
      
    
  </div>

</div></div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part--> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.toggle.buttons.js"></script> 
<script src="js/masked.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_common.js"></script> 
<script src="js/wysihtml5-0.3.0.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/bootstrap-wysihtml5.js"></script> 
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>

