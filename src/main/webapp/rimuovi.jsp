<%@page import="it.prova.gestioneTelevisori.model.Televisore"%>
<%@page import="it.prova.gestioneTelevisori.service.MyServiceFactory"%>
<%@page
	import="it.prova.gestioneTelevisori.service.televisore.TelevisoreService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>rimuovi televisore</title>
</head>
<body>

	<%
	TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
	Long id = Long.parseLong((String) request.getAttribute("idDaEliminare"));
	Televisore televisoreDaEliminare = televisoreService.cercaPerId(id);
	%>

	<p>
		<b>Sei certo di voler rimuovere questo elemento?</b>
	</p>
	<br> Marca:
	<%=televisoreDaEliminare.getMarca()%>
	<br> Modello:
	<%=televisoreDaEliminare.getModello()%>
	<br> Prezzo:
	<%=televisoreDaEliminare.getPrezzo()%>
	<br> NumeroPollici:
	<%=televisoreDaEliminare.getNumeroPollici()%>
	<br> Codice:
	<%=televisoreDaEliminare.getCodice()%>
	<br>
	<form action="ExecuteDeleteServlet" method="post">
		<input type="hidden" name="idTelevisore"
			value="<%=televisoreDaEliminare.getId()%>">
		<button>conferma</button>
	</form>

</body>
</html>