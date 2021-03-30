<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.DonazioneTab" %> 

<jsp:useBean id="GestisciDonazioniBoundary" scope="application" class="beanWeb.GestisciDonazioniBoundary"/>
<jsp:setProperty name="GestisciDonazioniBoundary" property="*"/>
 
 <%
 	if(request.getParameter("INDIETRO") != null){
 		// GestisciDonazioniBoundary.;
 %>
		 <jsp:forward page="homeCaritas.jsp"/>
 <%
 	}
 	
 	if(request.getParameter("contatta") != null){
 		if(request.getParameter("Email") != null){
%>
		<jsp:forward page="contattaCaritas.jsp"/>
<%
 		GestisciDonazioniBoundary.contattaVolontario();
 		}
 	}
%>
	
<% 	
 	if (request.getParameter("eliminaDonazione") != null){
 %>
 		<jsp:forward page="eliminaDonazione.jsp"/>
 <%
 	}
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTISCI DONAZIONI</title>
<link rel="stylesheet" href ="../css/gestisciDonaz.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
<form action = "gestisciDonazioni.jsp" name ="my" method = "POST">
	<h1>DONAZIONI ALLA CARITAS</h1>
	<div style= "position:absolute;top: 1%; left:70%">
	<img src="../img/caritas.jpg"  width= "350px" height= "200px">
	</div>
	
<div class ="tab">
 <table class="content-table" id = "giorno">
  <thead>
    <tr> 
      <th>ID VOLONTARIO</th>
      <th>ID DONAZIONE </th>
      <th>TIPO</th>
      <th>DESCRIZIONE</th>
      <th>INDIRIZZO</th>
      <th>STATO</th>
    </tr>
  </thead>
  <tbody>


<%
	List<DonazioneTab> list = GestisciDonazioniBoundary.getInstance().loadFormDonazione();
	int i = 0;
	while (i < list.size()){
%>
<tr>
<td><% out.println(list.get(i).getCodVol()); %><input type="checkbox" name="Email" value="Email"/></td>
<td><% out.println(list.get(i).getIdDon());%></td>
<td><% out.println(list.get(i).getTipologia());%> </td>
<td><% out.println(list.get(i).getDescrizione());%> </td>
<td><% out.println(list.get(i).getIndirizzo() ); %> </td>
<td><% out.println(list.get(i).getStato()); %> </td>
</tr>

<%
	i++;
}
%>

  </tbody>
</table>
	<div class = "ritira">
	<button type="submit" name= "RITIRA DONAZIONE" value="RITIRA DONAZIONE">RITIRA DONAZIONE</button>
	</div>
	<div class = "contatta">
	<button type="submit" name= "contatta" value="contatta">CONTATTA VOLONTARIO</button>
	</div>
	<div class = "cancella">
	<button type="submit" name= "eliminaDonazione" value="eliminaDonazione">ELIMINA DONAZIONE</button>
	</div>
	<div class = "ind">
	<button type = "submit" name = "INDIETRO" value = "INDIETRO">INDIETRO</button>
	</div>
</form>
</body>
</html>