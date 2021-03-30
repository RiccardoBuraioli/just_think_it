<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="PrenotaTurnoBoundary" scope="request" class="beanWeb.PrenotaTurnoBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="PrenotaTurnoBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("PARTECIPA")!=null){
		if (PrenotaTurnoBoundary.getInstance().prenotaTurno(request.getParameter("nome_giorno"),request.getParameter("ora_inizio"),request.getParameter("ora_fine"),request.getParameter("Curriculum")) == 0){


%>
	<jsp:forward page="NewMap.jsp"/>
<%
		}}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRENOTA TURNO</title>
<link rel="stylesheet" href ="../css/prenotaTurnoMap.css">
</head>
<body>
		<form action = "prenotaTurnoMap.jsp" name = "reg" method = "POST">
			<div class = "header">
				<h2>JUST THINK IT</h2>
			</div>
			<h4 align = "center">Grazie al tuo sostegno moltissime persone te ne saranno grate e potranno essere aiutate!</h4>
			<h6>*dopo aver inviato la richiesta verrà inoltrata una notifica se accettata</h6>
			<div class = "giorni">
	<h3 class = "turno">Giorni di prenotazione</h3>
	<select id = "nome_giorno" name="nome_giorno">
	<option  value="Lunedi" >Lunedi</option>
	<option  value="Martedi" >Martedi </option>
	<option  value="Mercoledi" >Mercoledi</option>
	<option  value="Giovedi" >Giovedi</option>
	<option  value="Venerdi">Venerdi</option>
	<option  value="Sabato" >Sabato</option>
	<option  value="Domenica" >Domenica</option>
	</select>
	</div>
	<div  class = "orario">
	<h3 class = "orari">Orari disponibili</h3>
	<select id = "ora_inizio" name="ora_inizio" >
	<option  value="08:00" >08:00</option>
	<option value="11:00" >11:00</option>
	<option  value="14:00" >14:00</option>
	<option  value="17:00" >17:00</option>
	<option  value="20:00" >19:00</option>
	</select>
	<select id = "ora_fine" name="ora_fine" >
	<option value = "11:00" >11:00</option>
	<option  value = "14:00" >14:00</option>
	<option  value = "17:00" >17:00</option>
	<option  value = "18:00" >19:00</option>
	<option  value = "21:00">21:00</option>
	</select>
	</div>
	

	<div align = "center" class = "text" >
	<h3 class = "cv">Inserisci il link al cv</h3>
	<input type="text" id ="Curriculum" name= "Curriculum"  placeholder="es.www.github.it"/>
	</div>
			<button type="submit" name= "PARTECIPA" value="PARTECIPA">PRENOTA</button>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
	</form>
</body>
</html>