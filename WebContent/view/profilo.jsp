<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="UserHomeBoundary" scope="request" class="bean.UserHomeBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="UserHomeBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	//UserHomeBoundary.initData(request.getParameter("Email"), request.getParameter("RecapitoTel"), request.getParameter("Indirizzo"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "profilo.jsp" name = "reg" method = "GET">
</form>

</body>
</html>