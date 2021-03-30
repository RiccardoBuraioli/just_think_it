<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%Class.forName("com.mysql.jdbc.Driver"); %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="DonationBoundary" scope="application" class="beanWeb.DonationBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="DonationBoundary" property="*"/>

<%	
	if(request.getParameter("CONFERMA")!=null){
		if("Vestiti".equals(request.getParameter("tipo"))){
				if ((DonationBoundary.getInstance().creaDonazione(1,request.getParameter("IndirizzoVolontario"), request.getParameter("descrizione") )== true)){
					
%>
		<jsp:forward page="NewMap.jsp"/>
<%		}}//}
			
		
		if("Cibo".equals(request.getParameter("tipo"))){
				if ((DonationBoundary.getInstance().creaDonazione(2,request.getParameter("IndirizzoVolontario"), request.getParameter("descrizione"))== true)){
%>
	<jsp:forward page="NewMap.jsp"/>
<%		
	}}}
	//}
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DONAZIONE</title>
<link rel="stylesheet" href ="../css/creaDonazioneMap.css">
</head>
<body>
	<form action = "creaDonazioneMap.jsp" name = "reg" method = "POST">
	<div  align = "center" class = "header">
				<h2>JUST THINK IT</h2>
			</div>
		
			<h4>La tua donazione è veramente importante per noi e fa la differenza </h4>
			<div class = "don">
		  <h3>Cosa vuoi donare?</h3>
			<h3>Vestiti<input type="checkbox" name="tipo" value="Vestiti"/>
			<input type="checkbox" name="tipo" value="Cibo"/> Cibo</h3>
		</div>
		<div align = "center" class = "descr">
		<h3>Inserisci breve desrizione del/dei prodotti:</h3>
		<input type="text" id= "descrizione" name= "descrizione"  placeholder="Ho donato 3kg di pasta" />
		</div>
		<div class = "indirizzo">
		<h3>Scrivi il tuo indirizzo</h3>
		<input type = "text" id = "IndirizzoVolontario" name = "IndirizzoVolontario"  placeholder = "via Luigi Settembrini">
		</div>
			<button type="submit" name= "CONFERMA" value="CONFERMA" onClick = "ConfermaDon()">CONFERMA</button>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
	</form>
 </body>
</html>
