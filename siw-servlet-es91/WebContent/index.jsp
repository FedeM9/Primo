<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utente</title>
<link rel="stylesheet" href="bootstrap.css">
</head>
<body>
	<section>
		<header>
			<h1>Gestore Prodotti:</h1>
		</header>
		
		<article >
		<div align = "center">
			<h2 align="left"> Inserisci prodotto: </h2>
			<form action="prodotto" method="post" style="width: 400px">
				<div>
					Nome*: <input type="text" name="nome" value="${prodotto.nome}" />${errNome}</div>
				<div>
					Descrizione*: <input type="text" name="descrizione"
						value="${prodotto.descrizione}" />${errDescrizione}</div>
				<div>
					Prezzo*: <input type="text" name="prezzo"
						value="${prodotto.prezzo}" />${errPrezzo}</div>
				<div>
					Data Scadenza*: <input type="text" name="dataScadenza"
						value="${prodotto.dataScadenza}" />${errDataScadenza}</div>
				<div>* Campo Obbligatorio</div>
				<input type="submit" name="command" value="invia" />

			</form>

			<div>
				<h2 align="left">Vedi Prodotti inseriti: </h2>
				<a href="prodotto">Lista Prodotti</a>
			</div>
			</div>
		</article>
		

	</section>
</body>
</html>