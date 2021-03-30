<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CaritasHomeBoundary" scope="application" class="beanWeb.CaritasHomeBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CaritasHomeBoundary" property="*"/>

<%
	if (request.getParameter("BACHECA") != null){
		CaritasHomeBoundary.getInstance().visualizzaBacheca();
%>
	<jsp:forward page="bachecaNecc.jsp"/>
<%
}
%>
<%
if(request.getParameter("GESTISCI DONAZIONI") != null){
	   CaritasHomeBoundary.getInstance().gestisciDonazioni();
   
%>
<jsp:forward page="gestisciDonazioni.jsp"/>
<%
}%>

<%
if(request.getParameter("GESTISCI TURNI") != null){
	   CaritasHomeBoundary.getInstance().gestisciTurni();
%>
<jsp:forward page="gestisciTurni.jsp"/>
<%
}%>

<%
if(request.getParameter("GESTISCI EVENTI") != null){
	   CaritasHomeBoundary.getInstance().gestisciEventi();
%>
<jsp:forward page="gestisciEventi.jsp"/>
<%
}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME CARITAS</title>
<link rel="stylesheet" href ="../css/homeCaritas.css">
</head>
<body>
<form action = "homeCaritas.jsp" name ="my" method = "POST">
	<div style= "position:absolute;top: 1%; z-index:1">
	<img src="../img/caritas.jpg"  width= "450px" height= "300px">
	</div>
	<div style = "position:absolute; top:11.5%;  left:27%;  z-index:0">
	<img src="../img/arcobaleno.jpg" width= "500px" height = "500px">
	</div>
	<h1>JUST THINK IT</h1>
	<h2>Search, Find, Help</h2>
	<div class = "profilo">
	<button type="submit" name= "PROFILO" value="PROFILO">PROFILO</button>
	</div>
	<div class = "help">
	<button type="submit" name= "HELP" value="HELP">HELP</button>
	</div>
	<div class = "cancella">
	<button type="submit" name= "CANCELLA ACCOUNT" value="CANCELLA ACCOUNT">CANCELLA ACCOUNT</button>
	</div>
	<div class = "bacheca">
	<button type="submit" name= "BACHECA" value="BACHECA">BACHECA</button>
	</div>
	<div class = "turni">
	<button type="submit" name= "GESTISCI TURNI" value="GESTISCI TURNI">GESTISCI TURNI</button>
	</div>
	<div class = "eventi">
	<button type="submit" name= "GESTISCI EVENTI" value="GESTISCI EVENTI">GESTISCI EVENTI</button>
	</div>
	<div class = "donazione">
	<button type="submit" name= "GESTISCI DONAZIONI" value="GESTISCI DONAZIONI">GESTISCI DONAZIONI</button>
	</div>
</form>
	<div class="box">
	<a class="button" href="#popup1"><button type="submit" name= "LOGOUT" value="LOGOUT">LOGOUT</button></a>
	</div>
	<div id="popup1" class="overlay">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<div class="content">
			<h3>Sei sicuro di voler uscire?</h3>
			<p>Se uscirai dovrai effettuare un nuovo accesso.</p>
		</div>
		<div class="ok">
		<a href = "index.jsp"><button type="submit" name= "" value="">OK</button></a>
		</div>
		<div class="annulla">
		<a href =  "homeVolontario.jsp"><button type="submit" name= "" value="">ANNULLA</button></a>
		</div>
	</div>
	</div>
</body>
</html>