<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CreaNecessitaBoundary" scope="application" class="beanWeb.CreaNecessitaBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CreaNecessitaBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("CREA ANNUNCIO")!=null){
		if (CreaNecessitaBoundary.creaAnnuncioPressed(request.getParameter("tipologia"),request.getParameter("urgenza"), request.getParameter("richiesta")) == true){
%>
	<jsp:forward page="homeCaritas.jsp"/>
<%			
	}
	}
	
	if(request.getParameter("indietro") != null){
%>
	<jsp:forward page="bachecaNecc.jsp"/>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREA NECESSITA'</title>
<link rel="stylesheet" href ="../css/creaNecess.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
	<form action = "creaNecessita.jsp" name = "reg" method = "POST">
	<h2>CREA NECESSITA'</h2>
	<div class = "pt1">
	<textarea id = "richiesta" name= "richiesta" placeholder="Scrivi qui le esigenze."/></textarea>
	</div>
	<div class = "tipo">
	<select id = "tipologia" name="tipologia" >
	<option id = "Vestiti" value="Vestiti" selected="selected">Vestiti</option>
	<option id = "Cibo" value= "Cibo" selected= "selected">Cibo</option>
	</select>
	</div>
	<div class = "grado">
	<select id = "urgenza" name="urgenza" >
	<option id = "Alta" value="Alta" selected="selected">Alta</option>
	<option id = "Normale" value="Normale" selected="selected">Normale</option>
	<option id = "Bassa" value="Bassa" selected="selected">Bassa</option>
	</select>
	</div>
	<div class = "invia">
	<a href = ""><button type="submit" name = "CREA ANNUNCIO" value = "CREA ANNUNCIO">CREA ANNUNCIO</button></a>
	</div>
	<div class = "ind">
	<button type = "submit" name = "indietro" value = "indietro">INDIETRO</button>
	</div>
	</form>
</body>
</html>