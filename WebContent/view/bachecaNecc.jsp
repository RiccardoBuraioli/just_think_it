<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.Necessita" %> 

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="BachecaPersonaleBoundary" scope="application" class="beanWeb.BachecaPersonaleBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="BachecaPersonaleBoundary" property="*"/>
<%
	Class.forName("com.mysql.jdbc.Driver");

 	if(request.getParameter("indietro")!=null){
 %>
 	<jsp:forward page="homeCaritas.jsp"/>
 <%
 	}
 	
 	if(request.getParameter("crea") != null){
%>
	<jsp:forward page="creaNecess.jsp"/>
<%
 	} 
 	
 	if(request.getParameter("eliminaNecessità") != null){
 %>
 	<jsp:forward page="eliminaNecessità.jsp"/>
 <%
 	} 	
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BACHECA NECESSITA'</title>
<link rel="stylesheet" href ="../css/bachecaNeccessità.css">
</head>
<body>
<form action = "bachecaNecc.jsp" name ="my" method = "POST">
<div style= "position:absolute;top: 1%; left:70%">
	<img src="../img/caritas.jpg"  width= "300px" height= "150px">
	</div>
		<h1>BACHECA NECESSITA'</h1>
<div class = "tab">
			<table class="content-table">
  <thead>
    <tr>
      <th>ID NECESSITA'</th>
      <th>TIPOLOGIA</th>
      <th>DESCRIZIONE</th>
      <th>URGENZA</th>
    </tr>
  </thead>
  <tbody>
 <%
	List<Necessita> list = BachecaPersonaleBoundary.getInstance().loadFormBacheca();
	int i = 0;
	while (i < list.size()){
%>
<tr>
<td><% out.println(list.get(i).getIdNece()); %>
<td><% out.println(list.get(i).getTipologia()) ;%> </td>
<td><% out.println(list.get(i).getDescrizione());%> </td>
<td><% out.println(list.get(i).getUrgenza()); %> </td>

<%
	i++;
	}
%>
  </tbody>
</table>
</div>
			<div class = "crea">
			<button type="submit" name = "crea" value = "crea">CREA NECESSITA'</button>
			</div>
			<div class = "elimina">
			<button type="submit" name = "eliminaNecessità" value = "eliminaNecessità">ELIMINA</button>
			</div>
			<div class = "ind">
			<button type = "submit" name = "indietro" value = "indietro">INDIETRO</button>
			</div>
</form>	
</body>
</html>
