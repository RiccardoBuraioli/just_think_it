<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="UserHomeBoundary" scope="application" class="beanWeb.UserHomeBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="UserHomeBoundary" property="*"/>
<%
	if(request.getParameter("CERCA CARITAS") != null){
		if(UserHomeBoundary.getInstance().searchCaritasButtonPressed() == 0){
%>
	<jsp:forward page="NewMap.jsp"/>
<%	
		}
	}
%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME VOLONTARIO</title>
<link rel="stylesheet" href ="../css/homeVolontario.css">
</head>
<body>
<form action = "homeVolontario.jsp" name ="my" method = "POST">
	<div style= "position:absolute;top: 1%; z-index:1">
	<img src="../img/caritas.jpg"  width= "450px" height= "300px">
	</div>
	<div style = "position:absolute; top:11.5%;  left:27%;  z-index:0">
	<img src="../img/arcobaleno.jpg" width= "500px" height = "500px">
	</div>
	<h1>JUST THINK IT</h1>
	<h2>Search, Find, Help</h2>
	<div  class = "cerca">
	<button type="submit" name= "CERCA CARITAS" value="COMPLETA REGISTRAZIONE">CERCA CARITAS</button>
	</div>
	<div class = "profilo">
	<button type="submit" name= "" value="">PROFILO</button>
	</div>
	<div class = "help">
	<button type="submit" name= "" value="">HELP</button>
	</div>

	<div class = "box2">
	<a  href = "#popup2"><button type="submit" name= "" value="">CANCELLA ACCOUNT</button></a>
	</div>
	<div id = "popup2" class = "overlay2">
	<div class = "popup2">
	<a class = "close2" href="#">&times;</a>
	<div class = "content2">
	<h3>Sei sicuro di voler cancellare il tuo account?</h3>
	<p>Perderai tutti i tuoi dati e potrai avere delle sanzioni.</p>
	</div>
	<div class = "okk">
	<a href = "index.jsp"><button type = "submit" name = "" value = ""> OK</button></a>
	</div>
	<div class = "annulla2">
	<a href = "homeVolontario.jsp"><button type = "submit" name = "" value =""> ANNULLA</button></a>
	</div>
	</div>
	</div>

</form>
	<div class="box">
	<a  href="#popup1"><button type="submit" name= "" value="">LOGOUT</button></a>
	</div>
	<div id="popup1" class="overlay">
	<div class="popup">
	<a class="close" href="#">&times;</a>
	<div class="content">
	<h3>Sei sicuro di voler uscire?</h3>
	<p>Se uscirai dovrai effettuare un nuovo accesso.</p>
	</div>
	<div class="ok">
	<a href = ""><button type="submit" name= "" value="">OK</button></a>
	</div>	
	<div class="annulla">
	<a href =  "homeVolontario.jsp"><button type="submit" name= "" value="">ANNULLA</button></a>
	</div>
	</div>
	</div>
	
</body>
</html>