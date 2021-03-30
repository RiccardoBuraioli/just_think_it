<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="RegistraCaritasBoundary" scope="request" class="beanWeb.RegistraCaritasBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="RegistraCaritasBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
 		if(request.getParameter("COMPLETA REGISTRAZIONE")!=null){
 			if (request.getParameter("Password").equalsIgnoreCase(request.getParameter("confermaPassword"))){
 				if (request.getParameter("Tipologia").equalsIgnoreCase("Vestiti")){
 					if ((RegistraCaritasBoundary.completaButtonPressed(request.getParameter("NomeCaritas"),request.getParameter("Password"),request.getParameter("IndirizzoCaritas")+ " "+ request.getParameter("Via")+" "+ request.getParameter("nCivico"),"Vestiti",request.getParameter("RecapitoTel"),request.getParameter("Email"), request.getParameter("cittadiResidenza"))) == true ){ 			
%>
       	<jsp:forward page="homeCaritas.jsp"/>

<%	
					}
 				}
 			else if ((request.getParameter("Tipologia").equalsIgnoreCase("Cibo"))){
	 				if ((RegistraCaritasBoundary.completaButtonPressed(request.getParameter("NomeCaritas"),request.getParameter("Password"),request.getParameter("IndirizzoCaritas")+ " "+ request.getParameter("Via")+" "+ request.getParameter("nCivico"),"Cibo",request.getParameter("RecapitoTel"),request.getParameter("Email"), request.getParameter("cittadiResidenza"))) == true ){
 			
%>
 			<jsp:forward page="homeCaritas.jsp"/>
<% 						}
	 				 }
	 			}
 			}
 		//}
 	
 	
 	 %>	 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Registrazione Caritas</title>
    <link rel="icon" sizes="64x64" href="../img/favicon.png">
    <link rel="stylesheet" href ="../css/registrazioneCaritas.css">
  </head>
  <body>
  	<div class ="ind">
    <a href ="registrazione.jsp">Indietro </a>
    </div>
		<div class = "titolo"><h2>Registrazione Caritas</h2></div>
	<form action = "registrazioneCaritas.jsp" name = "reg" method = "POST">
    <div class="NomeCaritas">
  				<h3>Nome della Caritas</h3>
  		<input type="text" id = "NomeCaritas" name= "NomeCaritas" placeholder="es. Caritas di Roma"/>
        		<h3>Password</h3>
        <input type="password" id= "Password" name= "Password"/>
        	<h3>Conferma Password</h3>
        <input type="password" id= "confermaPassword" name= "confermaPassword"/>
	</div>
	<div class= "citta">			
			<h3>Provincia</h3>
        <input type="text" id = "cittadiResidenza" name= "cittadiResidenza"   placeholder="es.Roma">		
        	<h3>Comune di Residenza</h3>
        <input type="text" id ="IndirizzoCaritas" name= "IndirizzoCaritas"  placeholder="es.Ostia"/>
	<h3>Via&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspN civico</h3>
  <div class = "via"><input type="text" id = "Via" name="Via" placeholder="es. Luigi settembrini" /></div>
  <div class = "n"><input type="text" id = "nCivico" name= "nCivico" placeholder="es.54"/></div>
     </div>
     <div class = "fine">
       <br/><br/><h3>Vestiti<input type="checkbox" name="Tipologia" value="clothes"/>
			  <input type="checkbox" name="Tipologia" value="food"/> Cibo</h3>
			   <h3>Telefono</h3>
        <input type="text" id= "RecapitoTel" name= "RecapitoTel" placeholder="es.34324234"/>
        		<h3>Email</h3>
        <input type="text" id = "Email"  name="Email" placeholder="es.caritasRoma@gmail.com"/>
      </div>
      <div class = "box">
		<br/><br/><button type="submit" name= "COMPLETA REGISTRAZIONE" value="COMPLETA REGISTRAZIONE">COMPLETA REGISTRAZIONE</button>
	</div>
	</form>
  </body>
</html>