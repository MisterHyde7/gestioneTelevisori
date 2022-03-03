<%@page import="it.prova.gestioneTelevisori.service.MyServiceFactory"%>
<%@page import="it.prova.gestioneTelevisori.model.Televisore"%>
<%@page import="it.prova.gestioneTelevisori.service.televisore.TelevisoreService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica</title>
</head>
<body>

	<%if(request.getAttribute("modificaErrata") != null) {%>
		<p style="color: red;">Inserire tutti i campi correttamente</p>
	<% } else {%>
	<p>Modifica dati televisore:</p>
	<%} %>

	<%
	TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
	Televisore televisoreDaModificare = televisoreService.cercaPerId((Long) request.getAttribute("idDaModificare"));
	%>

	<br>
	<form action="ExecuteModificaServlet" method="post">
		
		Marca da modificare: <%= televisoreDaModificare.getMarca() %>
		<br>
		Nuova marca:
		<input type="text" name="nuovaMarca">
		<br>
		Modello da modificare: <%= televisoreDaModificare.getModello() %>
		<br>
		Nuovo modello:
		<input type="text" name="nuovoModello">
		<br>
		Prezzo da modificare: <%= televisoreDaModificare.getPrezzo() %>
		<br>
		Nuovo prezzo:
		<input type="text" name="nuovoPrezzo">
		<br>
		Numero di pollici da modificare: <%= televisoreDaModificare.getNumeroPollici() %>
		<br>
		Nuovo numero di pollici:
		<input type="text" name="nuovoNumeroPollici">
		<br>
		Codice da modificare: <%= televisoreDaModificare.getCodice() %>
		<br>
		Nuovo codice:
		<input type="text" name="nuovoCodice">
		<br>
		
		<input type="hidden" name="idTelevisore" value="<%= televisoreDaModificare.getId() %>">
		<button>Conferma</button>
		
	</form>
	
</body>
</html>