<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.EventTab" %>

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="GestisciEventiBoundary" scope="application" class="beanWeb.GestisciEventiBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="GestisciEventiBoundary" property="*"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTISCI EVENTI NEGOZIO</title>
<link rel="stylesheet" href ="../css/gestisciEventiNeg.css">
<link rel="icon" sizes="64x64" href="../img/favicon.png">
</head>
<body>
<form action = "gestisciEventiNegozio.jsp" name ="my" method = "POST">
	<div style= "position:absolute;top: 1%; left:70%">
	<img src="../img/caritas.jpg"  width= "350px" height= "200px">
	</div>
	
	<h1>GESTIONE DEGLI EVENTI</h1>
	<div class = "tab">
			<table class="content-table" id = "giorno">
  <thead>
    <tr> 
      <th>Evento</th>
      <th>Negozio</th>
      <th>Note Evento</th>
      <th>Partecipanti</th>
      <th>Importo raggiunto</th>
    </tr>
  </thead>
  <tbody>


<%
	List<EventTab> list = GestisciEventiBoundary.getInstance().loadShopBoundary();
	int i = 0;
	while (i < list.size()){
%>
<tr>
<td><% out.println(list.get(i).getNomeEvento());%> </td>
<td><% out.println(list.get(i).getNomeCaritas());%> </td>
<td><% out.println(list.get(i).getNoteEvento() ); %> </td>
<td><% out.println(list.get(i).getNumPartecipanti()); %> </td>
<td><% out.println(list.get(i).getImportoRaggiunto()); %> </td>
</tr>

<%
	i++;
}
%>

  </tbody>
</table>
</div>
	
	
	<div class = "contatta">
	<button type="submit" name= "contatta" value="contatta">CONTATTA CARITAS</button>
	</div>
	<div class = "modifica">
	<button type="submit" name= "modifica" value="modifica">MODIFICA EVENTO</button>
	</div>
	<div class = "cancella">
	<button type="submit" name= "CANCELLA " value="CANCELLA">CANCELLA EVENTO</button>
	</div>
	<div class = "ind">
	<button type = "submit" name = "INDIETRO" value = "INDIETRO ">INDIETRO</button>
	</div>
</form>
</body>
</html>