<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Test Page</title>
</head>
<body>
	<form>
		<label>Berechnung: </label>
		<input type="text" id="calculation" name="calculation" value=<%= 3 * 5 %>>
		<label>Datum: </label>
		<input type="text" id="date" name="date" value=<%=new java.text.SimpleDateFormat().format(new java.util.Date())%>>
		
		<p>
		
		<label>Codewort: </label>
		<input type="text" id="codeword" name="codeword">
		<label>Verschiebung: </label>
		<input type="number" id="offset" name="offset">
		<input type="submit" value="Passwort generieren">
		
		<%! String tempString = ""; %>
	<% 
	if( request.getParameter("codeword") != null && request.getParameter("offset") != null)
    {
        String codewordFromInput = request.getParameter("codeword");
        int offsetFromInput;
        if(!request.getParameter("offset").equals(""))
			 offsetFromInput = Integer.parseInt(request.getParameter("offset"));
        else
        	offsetFromInput = 0;
		
		tempString = "";
	        char tempChar;
	        for(char currentChar : codewordFromInput.toCharArray())
	        {
	        	tempString += (char)(currentChar + offsetFromInput);
	        } 
    }
        
    %>
    
    <p>Output : "<%= tempString %>"</p>
    <p>Http-Method : <%= request.getMethod() %></p>
    <p><%= getServletContext().getInitParameter("param") %></p>
	</form>
</body>
</html>