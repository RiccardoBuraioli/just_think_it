<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.CoordinateMap" %>
<%Class.forName("com.mysql.jdbc.Driver"); %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CercaCaritas" scope="application" class="beanWeb.CercaCaritas"/>
 
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CercaCaritas" property="*"/>
 

<%

    List<CoordinateMap> caritas = CercaCaritas.initMarkersCaritas();
    List<CoordinateMap> evento = CercaCaritas.initMarkersEvento();
    List<CoordinateMap> donazione = CercaCaritas.initMarkersDonazione();

%>

<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="../css/newMap.css" />
      <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js"></script>
      <meta charset="ISO-8859-1">
      <title>MAPPA</title>
     <style>
      #map {position: absolute; top: 110px; right: 0; bottom: 0; left: 320px;     width: 1030px; height: 530px}
    </style>
  </head>
  <script type="text/javascript">
    	var idMarker = 0;
    	var hidden = false;
    	var tipoUtente = "";
    </script>
  <body>

<form action = "NewMap.jsp" name = "reg" method = "POST">
<div class = "cordinate">
<input type="button" value="INDICATORE" onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)">
 <label for="latitude">Latitude:</label>
<input id="latitude" type="text" />
<label for="longitude">Longitude:</label>
<input id="longitude" type="text" />
</div>
    <div class = "header">
        <h2>JUST THINK IT</h2>
    </div>
      <div class = "ind">
        <a href= "">INDIETRO</a>
    </div>
    
<% if(CercaCaritas.getInstance().trovaRuoloBean().equalsIgnoreCase("Volontario")){%>

<button  id = "donazione" name = "donazione" style="visibility:hidden" >CREA DONAZIONE</button> 
<button id = "necessita" name = "necessita" style="visibility:hidden">VEDI BACHECA</button>
<button id = "turno" name = "turno" style="visibility:hidden">PRENOTA TURNO</button> 
<button id = "partecipaEvento" name = "partecipaEvento" style="visibility:hidden">PARTECIPA EVENTO</button>

<script> tipoUtente="Volontario";</script>

<%}

else if(CercaCaritas.getInstance().trovaRuoloBean().equalsIgnoreCase("Negozio")){%>
	<button  id = "donazione" name = "donazione" style="visibility:hidden" >CREA DONAZIONE</button> 
	<button id = "necessita" name = "necessita" style="visibility:hidden">VEDI BACHECA</button>
	<button id = "promuoviEvento" name = "promuoviEvento" style="visibility:hidden">PROMUOVI EVENTO</button>

	
<script>tipoUtente = "Negozio";</script>	
<%}%>



<!-- <button id = "turno" name = "">PROMUOVI EVENTO</button>  -->


<div class =  "hidden">
 <input type="text" id = "donazioneInput" name= "donazioneInput"> 
 <input type="text" id = "turnoInput" name= "turnoInput"> 
 <input type="text" id = "eventoInput" name= "eventoInput"> 
 <input type="text" id = "necessitaInput" name= "necessitaInput">
 <input type="text" id = "promuoviInput" name= "promuoviInput">
 <input type="text" id = "partecipaInput" name= "partecipaInput">
</div>


</form>

<div id="map"></div>
<div class = "check">
<div>
  <input type="checkbox" class="gaucher" id="1" name="gaucher[]" onClick="actionCaritas()"  onchange="processCheck(this)">
  <label for="1">Caritas</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="2" name="gaucher[]"   onClick="actionPartecipaEvento()" onchange="processCheck(this)">
  <label for="2">Eventi</label>
</div>
 
<div>
  <input type="checkbox" class="gaucher" id="3" name="gaucher[]" onchange="processCheck(this)">
  <label for="3">Donazioni</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="4" name="gaucher[]" onchange="processCheck(this)">
  <label for="4">MioMarker</label>
</div>
</div>

<%
	if(request.getParameter("promuoviEvento") != null){
 		String parametroPromuovi = request.getParameter("promuoviInput");
 		System.out.println(parametroPromuovi);
		out.print("<b>"+parametroPromuovi+"</b>");
		CercaCaritas.getInstance().promuoviEvento(Integer.parseInt(parametroPromuovi));
	
%>
	<jsp:forward page="promuoviEventoMap.jsp"/>
<%  
	}
    if(request.getParameter("donazione") != null){
     	String parametro = request.getParameter("donazioneInput");
    	out.print("<b>"+parametro+"</b>");
    	CercaCaritas.getInstance().creaDonazione(Integer.parseInt(parametro));
%>
 			<jsp:forward page="creaDonazioneMap.jsp"/>
<%
    }   
    if(request.getParameter("evento") != null){
     	String parametroEvento = request.getParameter("eventoInput");
    	System.out.println(parametroEvento);
    	out.print("<b>"+parametroEvento+"</b>");
    	CercaCaritas.getInstance().partecipaEvento(Integer.parseInt(parametroEvento));
%>
		<jsp:forward page="partecipaEventoVolontario.jsp"/>
<%
    }
    
    if(request.getParameter("turno") != null){
     	String parametroTurno = request.getParameter("turnoInput");
    	out.print("<b>"+parametroTurno+"</b>");
    	CercaCaritas.getInstance().prenotaTurno(Integer.parseInt(parametroTurno));
%>
		<jsp:forward page="prenotaTurnoMap.jsp"/>
<%
}
    if(request.getParameter("necessita") != null){
     	String parametroNecessita = request.getParameter("necessitaInput");
    	out.print("<b>"+parametroNecessita+"</b>");
    	CercaCaritas.getInstance().vediNecessita(Integer.parseInt(parametroNecessita));
%>
		<jsp:forward page="bachecaCaritasMap.jsp"/>
<%
}
    
    if(request.getParameter("partecipaEvento") != null){
     	String parametroPartecipa = request.getParameter("partecipaInput");
    	out.print("<b>"+parametroPartecipa+"</b>");
    	CercaCaritas.getInstance().partecipaEvento(Integer.parseInt(parametroPartecipa));
%>
		<jsp:forward page="partecipaEventoVolontario.jsp"/>
<%
}
    
        String jsMarker = "";
        for(int i=0; i< caritas.size(); i++){
            String myY = caritas.get(i).getLongitudine();
            String myX = caritas.get(i).getLatitudine();

            int id = caritas.get(i).getIdMarker();
            jsMarker += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Caritas\"},\"id\": " + id + " }";
            if(i != caritas.size() -1 ){
                jsMarker +=",";
            }
        }
        String jsMarkerEvento = "";
        for(int i=0; i< evento.size(); i++){
            String myY = evento.get(i).getLongitudine();
            String myX = evento.get(i).getLatitudine();            
            int id = evento.get(i).getIdMarker();
            jsMarkerEvento += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Evento\"},\"id\": " + id + " }";
            if(i != evento.size() -1 ){
                jsMarkerEvento +=",";
            }
        }



        String jsMarkerDonazioni = "";
        for(int i=0; i< evento.size(); i++){
            String myY = donazione.get(i).getLongitudine();
            String myX = donazione.get(i).getLatitudine();            
            int id = donazione.get(i).getIdMarker();
            jsMarkerDonazioni += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Donazione\"},\"id\": " + id + " }";
            if(i != donazione.size() -1 ){
                jsMarkerDonazioni +=",";
            }
        }

		int idUte = CercaCaritas.getIdUte();

        
        

    %>
   <script>
    
    var caritasMarker = {"type": "FeatureCollection","features": [ <%= jsMarker %> ]};

    var eventoMarker= {"type": "FeatureCollection","features": [ <%= jsMarkerEvento %> ]};

    var donazioniMarker = {"type": "FeatureCollection","features": [ <%= jsMarkerDonazioni %> ]};

  
 
   var map = L.map('map').setView([41.87, 12.47], 8);
 
      var baselayer1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
      }).addTo(map);
 

	
        var layerDonazioni = L.geoJSON(donazioniMarker);
        var layerEvento = L.geoJSON(eventoMarker);
        var layerCaritas = L.geoJSON(caritasMarker);
		
        
		
		  var marker = L.marker([41.87, 12.47],{
		    	draggable: true
		    	}).addTo(map);
		    	marker.on('dragend', function (e) {
		    	updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		    	});
		    	map.on('click', function (e) {
		    		marker.setLatLng(e.latlng);
		    		updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		    		});
		
		    	
		    
		    	
		    	function updateLatLng(lat,lng,reverse) {
		    		if(reverse) {
		    		marker.setLatLng([lat,lng]);
		    		map.panTo([lat,lng]);
		    		} else {
		    		document.getElementById('latitude').value = marker.getLatLng().lat;
		    		document.getElementById('longitude').value = marker.getLatLng().lng;
		    		map.panTo([lat,lng]);
		    		}
		    	}
		    	
		    	
		
		
      var layers = [layerCaritas, layerEvento, layerDonazioni];

      selId = null;

        var  tipo;
        var id;
       
           
      function onClick(e) {
    	  tipo = e.layer.feature.properties.popupContent;
    	  
    	  if(tipo == "Caritas"){
    		  idMarker= e.layer.feature.id; 
    		  document.getElementById("donazioneInput").value=idMarker;
    		  document.getElementById("turnoInput").value=idMarker;
    		  document.getElementById("necessitaInput").value=idMarker;  
    		  document.getElementById("promuoviInput").value=idMarker;  
    	  }  	 
    	  else if (tipo == "Evento"){
    		  document.getElementById("partecipaInput").value=idMarker; 
    	  }
          alert(e.layer.feature.properties.popupContent);           
        }

      function processCheck(checkbox) {
        var checkId = checkbox.id;
 
        if (checkbox.checked) {
          if (selId != null) {
            map.removeLayer(layers[selId - 1]);
            document.getElementById(selId).checked = false;
          }
         
          layers[checkId - 1].addTo(map).on('click', onClick);
          selId = checkId;
          }
        else {
          map.removeLayer(layers[checkId - 1]);
          selId = null;
        }
      }

   
    function actionCaritas() {
        hidden = !hidden;
        if (tipoUtente == "Volontario"){
        if(hidden) {
            document.getElementById('donazione').style.visibility = 'visible';
            document.getElementById('necessita').style.visibility = 'visible';
            document.getElementById('turno').style.visibility = 'visible';
           
         
        } else {
            document.getElementById('donazione').style.visibility = 'hidden';
            document.getElementById('turno').style.visibility = 'hidden';
            document.getElementById('necessita').style.visibility = 'hidden';
        	}
        }
        else if (tipoUtente = "Negozio"){
        	if(hidden) {
        		document.getElementById('donazione').style.visibility = 'visible';
           	 	document.getElementById('necessita').style.visibility = 'visible';
           	 	document.getElementById('promuoviEvento').style.visibility = 'visible';
        }
        else{
        	document.getElementById('donazione').style.visibility = 'hidden';
            document.getElementById('necessita').style.visibility = 'hidden';
            document.getElementById('promuoviEvento').style.visibility = 'hidden';
        	}
        }
    }
    
    function actionPartecipaEvento() {
        hidden = !hidden;
        if(hidden) {
            document.getElementById('partecipaEvento').style.visibility = 'visible';
        } else {
            document.getElementById('partecipaEvento').style.visibility = 'hidden';
        }
    }
</script>
	
    </body>
</html>