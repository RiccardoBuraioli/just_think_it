<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CreaTurnoBoundary" scope="application" class="beanWeb.CreaTurnoBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CreaTurnoBoundary" property="*"/>
<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("CREA TURNO") != null){
		if(CreaTurnoBoundary.creaTurnoPressed(request.getParameter("nome_giorno"),request.getParameter("oraInizio"),request.getParameter("oraFine"),request.getParameter("numMaxParte"),request.getParameter("note")) == true){
%>
	<jsp:forward page="gestisciTurni.jsp"/>
<%
			
		}
	}
	
	if(request.getParameter("indietro") != null){
%>
	<jsp:forward page="gestisciTurni.jsp"/>
<%
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREA TURNO</title>
<link rel="stylesheet" href ="../css/crea.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<form action = "creaTurno.jsp" name = "reg" method = "POST">
	<h1>CREA TURNO LAVORATIVO</h1>
	<div class = "pt1">
	<div class = "giorni">
			<h3>Che giorno?</h3>
			<select id = "nome_giorno" name="nome_giorno" >
			<option id = "Lunedì" value="Lunedì" selected="selected">Lunedì</option>
			<option id = "Martedì" value= "Martedì" selected= "selected">Martedì</option>
			<option id = "Mercoledì" value="Mercoledì" selected="selected">Mercoledì</option>
			<option id = "Giovedì" value= "Giovedì" selected= "selected">Giovedì</option>
			<option id = "Venerdì" value="Venerdì" selected="selected">Venerdì</option>
			<option id = "Sabato" value= "Sabato" selected= "selected">Sabato</option>
			<option id = "Domenica" value="Domenica" selected="selected">Domenica</option>
			</select>
	</div>
	
	<div class = "orarioInizio">
	 <h3>Orario di inizio turno</h3>
	 <input type="text" id="oraInizio" name= "oraInizio" placeholder="es 12:00"/>
	</div>
	</div>
	<div class = "pt2">
	 <h3>Orario fine turno</h3>
	 <input type="text" id= "oraFine" name= "oraFine" placeholder="es 12:00"/>
	 <h3>Numero massimo di partecipanti</h3>
	 <input type="text" id= "numMaxParte" name= "numMaxParte" placeholder="es 340"/>
	</div>
	<div class = "note">
	 <h3>Note</h3>
	 <textarea id = "note" name= "note" placeholder = "ciao"></textarea>
	</div>
	<div class = "crea">
	 <button type = "submit" name = "crea" value = "crea">Crea Turno</button>
	 </div>
	 <div class = "ind">
	<button type = "submit" name = "indietro" value = "indietro">INDIETRO</button>
	</div>
	 </form>
</body>
</html>