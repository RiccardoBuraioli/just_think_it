<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>REGISTRATI COME?</title>
  <link rel="stylesheet" href ="../css/registration.css">
  <link rel="icon" sizes="64x64" href="../img/favicon.png">
 </head>
 <body>
 		<div style = "position:absolute; top : 0%;">
	<img src="../img/colori.jpg" width="1355px" height="650px">
	</div>
		<div class = "Title">Welcome to JustThinkIt</div>
		<p class="reg">Scegli la modalità di registrazione</p>
		

		<p class= "vol">Volontario</p>
		<div class = "Volontario">
		  <a href ="registrazioneVolontario.jsp"> <button type="submit"> Registrati come Volontario</button></a>
		</div>

		<p class= "car">Caritas</p>
		<div class = "Caritas">
		 <a href ="registrazioneCaritas.jsp"> <button type="submit">  Registrati come Caritas</button></a>
		</div>

		<p class= "neg">Negozio</p>
		<div class = "Negozio">
		  <a href ="registrazioneShop.jsp"><button type="submit"> Registrati come Negozio</button></a>
		</div>
		
		<div class = "ind">
		<p><a class = "ind"href ="index.jsp">Torna indietro</a></p>
		</div>
 </body>
</html>
