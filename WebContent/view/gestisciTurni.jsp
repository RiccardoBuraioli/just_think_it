<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.TurnoTab" %>
   
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="GestisciTurniBoundary" scope="application" class="beanWeb.GestisciTurniBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="GestisciTurniBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
  if (request.getParameter("modifica") != null){
	if (GestisciTurniBoundary.ModificaTurno(request.getParameter("note")) == true){
		
%>	
		<jsp:forward page="homeCaritas.jsp"/>
<% 
  	}}
%>    
<%
	if(request.getParameter("crea") !=  null){
		GestisciTurniBoundary.creaTurno();
%>
	<jsp:forward page="creaTurno.jsp"/>
<%
	}
	
	if(request.getParameter("indietro")!= null){

%>
	<jsp:forward page="homeCaritas.jsp"/>
<%
	}
 	
 	if(request.getParameter("eliminaTurno") != null){
 %>
 	<jsp:forward page="eliminaTurno.jsp"/>
 <%
 	} 	
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTISCI TURNI</title>
<link rel="stylesheet" href ="../css/gestisciTurni.css">
</head>
<body>
	<form action = "gestisciTurni.jsp" name = "reg" method = "POST">
	<div style= "position:absolute;top: 1%; left:74%">
  <img src="../img/caritas.jpg"  width= "300px" height= "150px">
	</div>
	<h1>GESTISCI TURNI</h1>
<div class = "tab">
			<table class="content-table" id = "giorno">
  <thead>
    <tr>
      <th>ID TURNO</th> 
      <th>GIORNO</th>
      <th>ORARIO</th>
      <th>PARTECIPANTI</th>
      <th>NOTE</th>
    </tr>
  </thead>
  <tbody>


<%
	List<TurnoTab> list = GestisciTurniBoundary.getInstance().loadFormTurni();
	int i = 0;
	while (i < list.size()){
%>
<tr>
<td><% out.println(list.get(i).getId()); %>
<td><% out.println(list.get(i).getGiorno());%> </td>
<td><% out.println(list.get(i).getOraIn());%><% out.println(list.get(i).getOraFine()); %> </td>
<td><% out.println(list.get(i).getPartecipanti()); %> </td>
<td><% out.println(list.get(i).getNote()); %> </td>
</tr>



<%
	i++;
}
%>

  </tbody>
</table>
</div>
			<div class = "note">
			<textarea id = "note" name= "note" placeholder ="se portare il pane è meglio"></textarea>
			</div>
			<div class = "crea">
			<button type="submit" name = "crea" value = "crea">CREA TURNO</button>
			</div>
			<div class = "elimina">
			<button type="submit" name = "eliminaTurno" value = "eliminaTurno">ELIMINA TURNO</button>
			</div>
			<div class = "modifica">
			<button type="submit" name= "modifica" value = "modifica">MODIFICA NOTE</button>
			</div>
			<div class = "ind">
			<button type = "submit" name = "indietro" value = "indietro">INDIETRO</button>
			</div>
		</form>
</body>
</html>