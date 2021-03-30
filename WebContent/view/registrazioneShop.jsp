<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="RegistrationShopBoundary" scope="request" class="beanWeb.RegistrationShopBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="RegistrationShopManagerBoundary" property="*"/>


<%
Class.forName("com.mysql.jdbc.Driver");
 		if(request.getParameter("COMPLETA REGISTRAZIONE")!=null){
 			if ( request.getParameter("confermaPassword").equalsIgnoreCase(request.getParameter("Password"))){
 				if ("Vestiti".equals(request.getParameter("Tipologia"))){
 					if ((RegistrationShopBoundary.registraNegozioPressed("Vestiti",request.getParameter("NomeNegozio"),request.getParameter("Password"),request.getParameter("IndirizzoNeg")+" "+ request.getParameter("Via")+ " "+ request.getParameter("nCivico"),request.getParameter("RecapitoTel"),request.getParameter("Email"),request.getParameter("Città")) == true )){ 			
%>
		<jsp:forward page="homeVolontario.jsp"/>
<%	
					}
 				}
 			else if ("Cibo".equals(request.getParameter("Tipologia"))){
	 				if ((RegistrationShopBoundary.registraNegozioPressed("Cibo",request.getParameter("NomeNegozio"),request.getParameter("Password"),request.getParameter("IndirizzoNeg")+ request.getParameter("Via")+ " "+ request.getParameter("nCivico"),request.getParameter("RecapitoTel"),request.getParameter("Email"),request.getParameter("Città")) == true )){
 			
%>
 			<jsp:forward page="homeVolontario.jsp"/>
<% 			
	 					 }
	 				}
 				}
 			}
 		
 	
 	
 	 %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE NEGOZIO</title>
<link rel="icon" sizes="64x64" href="../img/favicon.png">
<link rel="stylesheet" href =" ../css/registrazioneShop.css">
</head>
<body>
    <a href ="registrazione.jsp"> Indietro </a>
		<div class = "titolo"><h2>Registrazione Negozio</h2></div>
	<form action = "registrazioneShop.jsp" name = "reg" method = "POST">
    <div class="Negozio">
  				<h3>Nome Negozio</h3>
        <input type="text" id = "NomeNegozio" name= "NomeNegozio" placeholder="es. Mario"/>
        	<h3>Password</h3>
        <input type="password" id= "Password" name= "Password"/>
        	<h3>Conferma Password</h3>
        <input type="password" id= "confermaPassword" name= "confermaPassword"/>
	</div>
	<div class= "citta">			
				<h3>Provincia</h3>
        <input type="text" id = "Città" name= "Città"   placeholder="es. Roma">
				<h3>Comune di Residenza</h3>
        <input type="text" id ="IndirizzoNeg" name= "IndirizzoNeg"  placeholder="es. Mario"/>
	<h3>Via&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspN civico</h3>
      <div class = "via"> <input type="text" id = "Via" name= "Via" placeholder="es. Luigi settembrini" /></div> 
      <div class = "n"><input type="text" id = "nCivico" name= "Indirizzo" placeholder="es.54"/></div>
     </div>
     <div class = "fine">
			 	 <h3>Telefono</h3>
        <input type="text" id= "RecapitoTel" name= "RecapitoTel" placeholder="es.34324234"/>
        <h3>Email</h3>
        <input type="text" id = "Email"  name="Email" placeholder="es.mariorossi@gmail.com"/>
         <br/><br/><h3>clothes<input type="checkbox" name="Tipologia" value="Vestiti"/>
			 <input type="checkbox" name="Tipologia" value="Cibo"/> food </h3>
      </div>
      <div class = "box">
		<br/><h3><button type="submit" name= "COMPLETA REGISTRAZIONE" value="COMPLETA REGISTRAZIONE">COMPLETA REGISTRAZIONE</button></h3>
		</div>
	</form>
</body>
</html>