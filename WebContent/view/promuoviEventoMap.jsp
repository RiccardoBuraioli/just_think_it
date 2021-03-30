<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="PromuoviEventoBoundary" scope="application" class="beanWeb.PromuoviEventoBoundary"/>
 
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="PromuoviEventoBoundary" property="*"/>
 
<%Class.forName("com.mysql.jdbc.Driver"); %>
<%
	if(request.getParameter("CONFERMA") != null){
		if (request.getParameter("Vestiti").equals("Vestiti")){
			if (PromuoviEventoBoundary.getInstance().confermaPressed(request.getParameter("NomeEvento"),"Vestiti",request.getParameter("NoteEvento"), request.getParameter("PrezzoEvento")) == true){		
%>
	     <jsp:forward page="NewMap.jsp"/>
<%
		}
	}
		
		else if (request.getParameter("Cibo").equals("Cibo")){
			if (PromuoviEventoBoundary.getInstance().confermaPressed(request.getParameter("NomeEvento"),"Cibo",request.getParameter("NoteEvento"), request.getParameter("PrezzoEvento")) == true){				
%>
	<jsp:forward page="NewMap.jsp"/>	
<%	
			}
		}
		else{
%>
			
<%		
		}
	}			
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROMUOVI EVENTO</title>
<link rel="stylesheet" href ="../css/promuoviEventoMap.css">
</head>
<body>
<form action = "promuoviEventoMap.jsp" name = "reg" method = "POST">
	<div class = "header">
		<h2>JUST THINK IT</h2>
	</div>
		<h4>Proponi un evento alla caritas</h4>
	<div class = "check">
	<h3>Vestiti<input type="checkbox"  name="Vestiti" value="Vestiti"/>
			<input type="checkbox" name="Cibo" value="Cibo"/> Cibo</h3>
	</div>
	<div class = "nome">		
	<h3>Nome evento</h3>
	<input type="text" id = "NomeEvento"  name="NomeEvento" placeholder=""/>
	</div>
	<div class = "prezzo">		
	<h3>Prezzo evento</h3>
	<input type="text" id = "PrezzoEvento"  name="PrezzoEvento" placeholder=""/>
	</div>
	<div class = "note">		
	<h3>Note evento</h3>
	<textarea id = "NoteEvento" name = "NoteEvento"></textarea>
	</div>
	<div class = "conferma">
		<button type="submit" name ="CONFERMA" value = "CONFERMA">CONFERMA</button>
	</div>
	<div class = "ind">
		<a href= "">INDIETRO</a>
	</div>
	</form>
</body>
</html>