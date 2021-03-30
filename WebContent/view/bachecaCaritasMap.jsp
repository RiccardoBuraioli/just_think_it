<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.Necessita" %> 

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="BachecaBoundary" scope="application" class="beanWeb.BachecaBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="BachecaBoundary" property="*"/>
    
<%
Class.forName("com.mysql.jdbc.Driver");
		 
		
		if (request.getParameter("CONTATTA CARITAS") != null){
			BachecaBoundary.getInstance().creaEmail();
%>
		<jsp:forward page="contattaCaritasMap.jsp"/>
<%
		}
		
		if (request.getParameter("CREA DONAZIONE") != null){
			BachecaBoundary.getInstance().creaDonazione();
%>
		<jsp:forward page="creaDonazioneMap.jsp"/>
<%
		}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BACHECA CARITAS</title>
<link rel="stylesheet" href ="../css/bachecaCaritasMa.css">
</head>
<body>
<form action = "bachecaCaritasMap.jsp" name = "reg" method = "POST">
	<div class = "header">
		<h2>JUST THINK IT</h2>
	</div>
		<h4>Benvenuti nella bacheca Caritas</h4>
<div class ="tab">
 <table class="content-table" id = "giorno">
  <thead>
    <tr> 
      <th>TIPOLOGIA</th>
      <th>URGENZA</th>
      <th>DESCRIZIONE</th>
    </tr>
  </thead>
  <tbody>
   
<%  List<Necessita> list = BachecaBoundary.getInstance().loadNecessita(); 
	int i = 0;
    while(i<list.size()){
		
%>
	<tr>
			<td><% out.println(list.get(i).getTipologia());%></td>
			<td><% out.println(list.get(i).getUrgenza());%></td>
			<td><% out.println(list.get(i).getDescrizione());%></td>	
	</tr>
<%
		
	
	i++;
}
%>

  </tbody>
</table>

	<div class = "contatta">
		<button type ="submit" name = "CONTATTA CARITAS" value = "CONTATTA CARITAS">CONTATTA CARITAS</button>
	</div>
	<div class = "donazione">
		<button type="submit" name = "CREA DONAZIONE" value = "CREA DONAZIONE">CREA DONAZIONE</button>
	</div>
			<div class = "ind">
			<a href= "NewMap.jsp">INDIETRO</a>
			</div>
	</form>
</body>
</html>