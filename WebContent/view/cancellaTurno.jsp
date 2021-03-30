<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="GestisciTurniBoundary" scope="application" class="beanWeb.GestisciTurniBoundary"/>
<jsp:setProperty name="GestisciTurniBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
		if(request.getParameter("CONFERMA") != null){
			GestisciTurniBoundary.cancellaTurno(request.getParameter("codiceTurno"));
		}
	
%>
	    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANCELLA TURNO</title>
</head>
<body>
<form action = "eliminaTurno.jsp" name = "reg" method = "POST">
	<p>Inserisci l'ID del turno che vorresti eliminare</p>
	<input type="text" id = "codiceTurno" name= "codiceTurno"   placeholder="4">
	<button type="submit" name= "CONFERMA" value="CONFERMA">CONFERMA</button>
</form>

</body>
</html>