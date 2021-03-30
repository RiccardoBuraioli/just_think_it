<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="GestisciTurniBoundary" scope="application" class="beanWeb.GestisciTurniBoundary"/>
<jsp:setProperty name="GestisciTurniBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
		if(request.getParameter("CONFERMA") != null){
			if(GestisciTurniBoundary.cancellaTurno(request.getParameter("id_turno"))== true){
			
 %>
 <jsp:forward page="gestisciTurni.jsp"/>
 <% 			
			
			}
		}
	
%>
	    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANCELLA TURNO</title>
<link rel="stylesheet" href ="../css/elimina.css">
</head>
<body>
<form action = "eliminaTurno.jsp" name = "reg" method = "POST">
	<h1>&nbsp&nbsp&nbsp&nbsp&nbspInserisci l'ID del turno che vorresti eliminare</h1>
	<p>(vedere nella tabella della pagina precedente)</p>
	<input type="text" id = "id_turno" name= "id_turno"   placeholder="4">
	<div class ="CONFERMA">
	<button type="submit" name= "CONFERMA" value="CONFERMA">CONFERMA</button>
	</div>
</form>
	<div class = "INDIETRO">
	<a href = "gestisciTurni.jsp"><button type = "submit" name = "indietro" value = "indietro">INDIETRO</button></a>
	</div>
</body>
</html>