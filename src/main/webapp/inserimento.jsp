<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<p>Inserimento nuovo elemento: </p>
	<br>
	<form action="ExecuteUpdateServlet" method="post">

		<label for="idMarca">Marca: </label> 
		<input type="text" name="marcaTelevisore" id="idMarca">
		<br>
		<label for="idModello">Modello: </label>
		<input type="text" name="modelloTelevisore" id="idModello">
		<br>
		<label for="idPrezzo">Prezzo: </label>
		<input type="text" name="prezzoTelevisore" id="idPrezzo">
		<br>
		<label for="idNumeroPollici">Numero pollici: </label>
		<input type="text" name="numeroPolliciTelevisore" id="idNumeroPollici">
		<br>
		<label for="idCodice">Codice: </label>
		<input type="text" name="codiceTelevisore" id="idCodice">
		<br>
		<button>Search</button>
		
	</form>
	
</body>
</html>