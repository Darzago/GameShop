<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article-Details</title>

<jsp:useBean id="article" class="logic.Article" scope="request"/>

</head>
<body>
    <%@ page import="logic.Article" %>
    <%@ page import="logic.ArticleManager" %>

    <p>Name: <%= article.getName() %></p>
    <p>Price: <%= article.getPrice() %></p>
    <p>Amount: <%= article.getAmount() %></p>
    
   	<form action="FrontController">
   		<input type="HIDDEN" name="articleId" value="<%=article.getId()%>">
        <button type="submit" name="action" value="buyArticle">In den Warenkorb legen</button>
    </form>
</body>
</html>