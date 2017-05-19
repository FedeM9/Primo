
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Prodotti</title>
</head>
<body>
	<h1>Lista Prodotti:</h1>
	<ul>
		<c:forEach var="product" items="${prodotti}">
			<li><a href="product?id=${product.id}">${product.name}</a>
				<form action="prodotto" method="post">
					<input type="hidden" value="${prodotto.id }" name="id"/>
					<input type="button" name="command" value="rimuovi" />
				</form></li>
		</c:forEach>
	</ul>
</body>
</html>