<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca di televisori</title>
</head>
<body>

	<p>
		<b>Benvenuto nella ricerca televisori</b>
	</p>

	<p>-inserisci i campi per avviare la ricerca</p>

	<form action="SearchServlet" method="post">

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