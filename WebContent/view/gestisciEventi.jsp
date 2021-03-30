<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.EventTab" %> 
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="GestisciEventiCaritasBoundary" scope="application" class="beanWeb.GestisciEventiCaritasBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="GestisciEventiCaritasBoundary" property="*"/>

<%
	if (request.getParameter("INDIETRO") != null){
		//GestisciEventiCaritasBoundary;	
%>
	<jsp:forward page="homeCaritas.jsp"/>
<%
	}

	if(request.getParameter("contatta") != null){
		GestisciEventiCaritasBoundary.contattaShop();
%>
	<jsp:forward page="contattaCaritas.jsp"/>
<%
	}
	
	if(request.getParameter("CANCELLA") != null){
%>
		<jsp:forward page="eliminaEvento.jsp"/>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTISCI EVENTI</title>
<link rel="stylesheet" href ="../css/gestisciEventi.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
<form action = "gestisciEventi.jsp" name ="my" method = "POST">
<div style= "position:absolute;top: 1%; left:75%">
	<img src="../img/caritas.jpg"  width= "300px" height= "150px">
	</div>
	<h1>GESTIONE DEGLI EVENTI</h1>
	<div class = "tab">
			<table class="content-table" id = "giorno">
  <thead>
    <tr> 
      <th>ID EVENTO</th>
      <th>EVENTO</th>
      <th>NEGOZIO</th>
      <th>NOTE EVENTO</th>
      <th>IMPORTO</th>
      <th>PARTECIPANTI</th>
      <th>STATO</th>
    </tr>
  </thead>
  <tbody>


<%
	List<EventTab> list = GestisciEventiCaritasBoundary.getInstance().loadFormEvento();
	int i = 0;
	while (i < list.size()){
%>
<tr>
<td><% out.println(list.get(i).getId()); %>
<td><% out.println(list.get(i).getNomeEvento());%> </td>
<td><% out.println(list.get(i).getNomeNegozio()); %>
<td><% out.println(list.get(i).getNoteEvento()); %> </td>
<td><% out.println(list.get(i).getImportoRaggiunto());%>/<%out.println(list.get(i).getPrezzoEvento()); %> </td>
<td><% out.println(list.get(i).getNumPartecipanti()); %> </td>
<td><% out.println(list.get(i).getStatoEvento()); %> </td>
</tr>



<%
	i++;
}
%>

  </tbody>
</table>
</div>
	
	
	<div class = "contatta">
	<button type="submit" name= "contatta" value="contatta">CONTATTA NEGOZIO</button>
	</div>
	<div class = "modifica">
	<button type="submit" name= "modifica" value="modifica">MODIFICA EVENTO</button>
	</div>
	<div class = "cancella">
	<button type="submit" name= "CANCELLA " value="CANCELLA">ELIMINA EVENTO</button>
	</div>
	<div class = "ind">
	<button type = "submit" name = "INDIETRO" value = "INDIETRO ">INDIETRO</button>
	</div>
</form>
</body>
</html>