<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FrontController">
	<label for="name">Articlename</label>
	<input type="text" name="name" required/>
	<label for="price">Articleprice</label>
	<input type="number" min="0.00" max="10000.00" step="0.01" name="price" required/>
	<label for="amount">Amount</label>
	<input type="number" name="amount" required>
	<button type="submit" name="action" value="addArticle">Add Article</button>
</form>
</body>
</html>