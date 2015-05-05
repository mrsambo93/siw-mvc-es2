<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rimuovi prodotto</title>
</head>
<body>
	<h1>Scegli il prodotto da cancellare</h1>
	<form action="controller/product.delete" method="get">
		<div>ID prodotto: <input type="text" name="ID"/></div>
		<div><input type="submit" name="sumbit" value="invia" /></div>
	</form>
</body>
</html>