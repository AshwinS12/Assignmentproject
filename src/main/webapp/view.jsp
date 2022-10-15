<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.*" %>
    <%@page import = "com.bean.Encapsulation" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library</title>
</head>
<body>
<h2 align = "center">Library of Books</h2>
<table>
<%
Object obj = session.getAttribute("Object");
if(obj==null){
	out.print("No books found");
}else{
	List<Encapsulation> list = (ArrayList<Encapsulation>)obj;
%>
<tr>
<th> BookId</th>
<th> Description</th>
<th>Genre</th>
<th>Sold</th>
</tr>
<%
for(Encapsulation e:list){
%>
<tr>
<td><%=e.getId() %></td>
<td><%=e.getDescripton() %></td>
<td><%=e.getGenre() %></td>
<td><%=e.getSold() %></td>
</tr>
<%
}
}%>
<tr>
	<td><button>
	<a href="index.html">Index</a></button></td>
	</tr>
	</table>
</table>
</body>
</html>