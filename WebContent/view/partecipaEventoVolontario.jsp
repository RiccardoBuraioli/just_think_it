<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="PartecipaEventoBoundary" scope="application" class="beanWeb.PartecipaEventoBoundary"/>
 
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="PartecipaEventoBoundary" property="*"/>   

<%Class.forName("com.mysql.jdbc.Driver"); %>
<%
	if (request.getParameter("PARTECIPA")!= null){
		if (PartecipaEventoBoundary.getInstance().partecipaEvento(request.getParameter("Importo"),request.getParameter("carta")) == true){
			
		}
%>
	<jsp:forward page="NewMap.jsp"/>
<%
	}

%> 
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PARTECIPA EVENTO VOLONTARIO</title>
<link rel="stylesheet" href ="../css/partecipaEventoVolontario.css">
</head>
<body>
<form action = "partecipaEventoVolontario.jsp" name ="my" method = "POST">
	 <div class = "header">
        <h2>JUST THINK IT</h2>
    </div>
	<h4>Gli eventi sono accessibili a chiunque, ma sarebbe gradito un piccolo contributo</h4>
	<h6>*donare &egrave; facoltativo, si pu&ograve; partecipare ugualmente all'evento</h6>
	<div class = "dono">
	<p>*Quanto vuoi donare?</p><input type="text" id = "Importo"  name="Importo" placeholder="10.00&euro;"/>
	</div>
	<div class = "carta">
	<p>*Carta di Credito</p><input type="text" id = "cartaDicredito"  name="Email" placeholder="67966869869790"/>
	</div>
	<div  class = "ind">
	<a href= "">INDIETRO</a>
	</div>
	<div class = "partecipa">
	<button type="submit" name= "PARTECIPA" value="PARTECIPA">PARTECIPA</button>
	</div>
</form>
</body>
</html>