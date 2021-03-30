<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="GestisciEventiBoundary" scope="application" class="beanWeb.GestisciEventiBoundary"/>
<jsp:setProperty name="GestisciEventiBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
		if(request.getParameter("CONFERMA") != null){
			if(GestisciEventiBoundary.eliminaEvento(request.getParameter("Id")) == true){ 
			
 %>
 <jsp:forward page="gestisciEventi.jsp"/>
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
<form action = "eliminaEvento.jsp" name = "reg" method = "POST">
	<h1>Inserisci l'ID della donazione che vorresti eliminare</h1>
	<p>(vedere nella tabella della pagina precedente)</p>
	<input type="text" id = "Id" name= "Id"   placeholder="4">
	<div class ="CONFERMA">
	<button type="submit" name= "CONFERMA" value="CONFERMA">CONFERMA</button>
	</div>
</form>
	<div class = "INDIETRO">
	<a href = "gestisciEventi.jsp"><button type = "submit" name = "indietro" value = "indietro">INDIETRO</button></a>
	</div>
</body>
</html>