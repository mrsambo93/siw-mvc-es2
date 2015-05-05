 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>siw-mvc-es2</title>
</head>
<body>
	<h1>Scegli un' operazione:</h1>
	<ul>
		<li><a href="<c:url value="/newProduct.jsp" />">Inserisci un nuovo prodotto</a></li>
		<li><a href="<c:url value="/controller/product.list" />">Mostra tutti i prodotti</a></li>
		<li><a href="<c:url value="/deleteProduct.jsp" />">Cancella un prodotto</a></li>
	</ul>
	${action}
</body>
</html>