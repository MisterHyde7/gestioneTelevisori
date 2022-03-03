<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio televisore</title>
</head>
<body>
	
	Marca: <%= request.getAttribute("marca") %>
	<br>
	Modello: <%= request.getAttribute("modello") %>
	<br>
	Prezzo: <%= request.getAttribute("prezzo") %>
	<br>
	NumeroPollici: <%= request.getAttribute("numeroPollici") %>
	<br>
	Codice: <%= request.getAttribute("codice") %>
	<br>
	<a href="searchForm.jsp">-Home</a>
	
</body>
</html>