<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="RegistrazioneVolontarioBoundary" scope="request" class="beanWeb.RegistrazioneVolontarioBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="RegistrazioneVolontarioBoundary" property="*"/>
<%
Class.forName("com.mysql.jdbc.Driver");
 		if(request.getParameter("COMPLETA REGISTRAZIONE")!=null){
 			if ( request.getParameter("confermaPassword").equalsIgnoreCase(request.getParameter("Password"))){
 				if ((RegistrazioneVolontarioBoundary.registraVolontarioPressed(request.getParameter("Nome"),request.getParameter("Cognome"),request.getParameter("Password"), request.getParameter("confermaPassword"),request.getParameter("indirizzo")+ " "+ request.getParameter("Via")+" "+ request.getParameter("nCivico"),request.getParameter("RecapitoTel"),request.getParameter("Email"),request.getParameter("DataNascita"), request.getParameter("Città"))) == true ){ 			
%>
  
			<jsp:forward page="homeVolontario.jsp"/>
<%
		
					}	 				 
 				}
 		else{
 			
%>

 			<jsp:forward page="registrazioneVolontario.jsp"/>
<% 		
	}
 			}
 	
 	
 	
%>	
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE VOLONTARIO</title>
<link rel="icon" sizes="64x64" href="../img/favicon.png">
<link rel="stylesheet" href =" ../css/registrazioneVolontario.css">
</head>
<body>
    <a href ="registrazione.jsp">Indietro</a>
		<div class = "titolo"><h2>Registrazione Volontario</h2></div>
	<form action = "registrazioneVolontario.jsp" name = "reg" method = "POST">
    <div class="Volontario">
  		<h3>Nome</h3>
        <input type="text" id = "Nome" name= "Nome" placeholder="es. Mario"/>
       	<h3>Cognome</h3>
        <input type="text" id= "Cognome" name= "Cognome" placheholder="es. Rossi"/>
        <h3>Data di Nascita</h3>
        <input type="text" id= "DataNascita" name= "DataNascita" placeholder="es. 17/03/1995"/>
    </div>
    <div class = "residenza">
        <h3>Provincia</h3>
        <input type="text" id ="Città" name= "Città"  placeholder="es.Roma"/>
		<h3>Comune di Residenza</h3>
        <input type="text" id ="indirizzo" name= "indirizzo"  placeholder="es.Ostia"/>        
        <h3>Via&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspN civico</h3>
 		 <div class = "via"><input type="text" id = "Via" name="Via" placeholder="es. Luigi settembrini" /></div>
  		<div class = "n"><input type="text" id = "nCivico" name= "nCivico" placeholder="es.54"/></div>
  	</div>
  	<div class = "fine">
  		<h3>Email</h3>
        <input type="text" id = "Email"  name="Email" placeholder="es.mariorossi@gmail.com"/>
        <h3>Telefono</h3>
        <input type="text" id= "RecapitoTel" name= "RecapitoTel" placeholder="es.3404125639"/>
     </div>
     <div class = "pass">
     	<h3>Password</h3>
        <input type="password" id= "Password" name= "Password"/>
        <h3>Conferma Password</h3>
        <input type="password" id= "confermaPassword" name= "confermaPassword"/>
	</div>
     
      <div class = "box">
		<button type="submit" name= "COMPLETA REGISTRAZIONE" value="COMPLETA REGISTRAZIONE">COMPLETA REGISTRAZIONE</button>
	</div>
	</form>
</body>
</html>