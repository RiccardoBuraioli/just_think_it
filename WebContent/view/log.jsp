<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="LoginBoundary" scope="request" class="beanWeb.LoginBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="LoginBoundary" property="*"/>


<%

	Class.forName("com.mysql.jdbc.Driver");

 	if(request.getParameter("login")!=null){
 		switch (LoginBoundary.loginPressed(request.getParameter("Username"), request.getParameter("Password"))){
 		case "Volontario":
 		
 %>
 	 	<jsp:forward page="homeVolontario.jsp"/>
 <%
 		break;
 		case "Caritas":
%>	
		<jsp:forward page="homeCaritas.jsp"/>
<%
		break;
 		case "Negozio":
%>
		<jsp:forward page="homeNegozio.jsp"/>
<%
 		break;}}
%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">

</head>
<body>
	<div style = "position:absolute; top : 0%;">
	<img src="../img/colori.jpg" width="1355px" height="650px">
	</div>
	<div class="loginbox">
	<img src="../img/avatar.png" class="avatar">
		<h1>Login here</h1>
		<form action = "log.jsp" name ="my" method = "POST">
			<p>Email</p>
			<input type="text" id ="Username"  name = "Username" placeholder="Enter username" autocomplete="off">
			<p>Password</p>
			<input type="password" id="Password" name = "Password" placeholder="Enter Password" autocomplete="off">
			<button type= "submit" name = "login" value = "login">Login</button>
			<a href="registrazione.html">Don't have an account?</a>
		</form>
	</div>
</body>
</html>