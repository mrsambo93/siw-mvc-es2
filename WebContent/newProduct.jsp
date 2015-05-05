<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserimento prodotto</title>
</head>
<body>
	<h1>Inserimento dati:</h1>
	<form action="controller/product.create" method="get">
		<div> Nome Prodotto: <input type="text" name="name" value="${param.name}"/>
			${nameError}
		</div>
		<div>Prezzo Prodotto: <input type="text" name="price" value="${param.price}"/>
			${priceError}
		</div>
		<div>Descrizione Prodotto: <input type="text" name="description" value="${param.description}"/>
			${descriptionError}
		</div>
		<div>Codice Prodotto: <input type="text" name="code" value="${param.code}"/>
			${codeError}
		</div>
		<div><input type="submit" name="sumbit" value="invia" /></div>	
	</form>
</body>
</html>