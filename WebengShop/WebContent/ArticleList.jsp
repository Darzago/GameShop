<%@page import="logic.ShoppingCartManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ page import="logic.Article" %>
<%@ page import="logic.ArticleManager" %>
<%@ page import="logic.ShoppingCart" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="shoppingCart" class="logic.ShoppingCart" scope="session"/>
<jsp:useBean id="articleList" class="java.util.ArrayList<Article>" scope="session"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article List</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Link</th>
        </tr>
        
    <% 
        for(Article currentArticle : articleList)
        {
            %>
            <tr>
            <td><%= currentArticle.getId() %></td>
            <td><%= currentArticle.getName() %></td>
            <td><a href="<%=response.encodeURL("FrontController?action=articleDetails")%>&articleId=<%=currentArticle.getId()%>">Details</a></td>
            </tr>
            <%
        }
    %>
    </table>
    
    <%

    %>
    
        <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Amount</th>
        </tr>
    	<% 
        for(Article currentArticle : shoppingCart.getArticles())
        {
            %>
            <tr>
            <td><%= currentArticle.getId() %></td>
            <td><%= currentArticle.getName() %></td>
            <td><%= currentArticle.getAmount() %></td>
            <td>
            <form action="FrontController">
            <input type="HIDDEN" name="removeID" value="<%=currentArticle.getId()%>">
            <button type="submit" name="action" value="removeArticle">Remove</button>
            </form>
        	</td>
            </tr>
             
     	<%
        }
    %>
    </table>
    
            
    <p>
    <form action="FrontController">
    	<button type="submit" name="action" value="checkout">Checkout</button>
    </form>
    <p>
	<form action="FrontController">
	<input type="HIDDEN" name="action" value="checkToken">
            <button type="submit" name="token" value="ichBins">Add Article</button>
    </form>
    <p>
    <%=
    		ShoppingCartManager.calculate(shoppingCart)
    %>

</body>
</html>