<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo jsp</title>
</head>
<body>
<%-- comentarioooooooo  Scriplet --%>
<%= new java.util.Date() %>
<% for(int i=1;i<=6;i++){%>
<h<%=i %>>Titulo <%=i %></h<%=i %>>
<%}%>
</body>
</html>