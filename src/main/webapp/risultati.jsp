<%@page import="java.util.List"%>
<%@page import="it.prova.gestioneTelevisori.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati</title>
</head>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}
</style>

<body>
	<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Azioni</th>
			</tr>
		</thead>
		<%
		List<Televisore> listaTelevisori = (List<Televisore>) request.getAttribute("televisori");
		for (Televisore televisoreItem : listaTelevisori) {
		%>
		<tr>
			<td><%=televisoreItem.getMarca()%></td>
			<td><%=televisoreItem.getModello()%></td>
			<td><%=televisoreItem.getPrezzo()%></td>
			<td><a
				href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Dettaglio</a>
				<a
				href="PrepareUpdateServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Modifica</a>
				<a
				href="PrepareDeleteServlet?idDaInviareComeParametro=<%=televisoreItem.getId()%>">Elimina</a>
			</td>
		</tr>
		<%
		}
		%>
		<tr>
			<td>
				<a href="PrepareUpdateServlet">-Inserisci nuovo televisore</a>
			</td>
		</tr>
	</table>
</body>
</html>