<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="modelos.Libro, java.util.ArrayList,"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	ArrayList<Libro> libros = (ArrayList<Libro>)request.getServletContext().getAttribute("libros");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>principal</title>
</head>
<body>
<section>
	<table>
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editorial</th>
			<th>Precio</th>
		</tr>
		 <c:forEach items="${libros}" var="libro">
		<tr>
			<td>${libro.id}</td>
			<td>${libro.isbn}<%-- libro.getIsbn() --%></td>
			<td>${libro.titulo}<%-- libro.getTitulo() --%></td>
			<td>${libro.autor}<%-- libro.getAutor() --%></td>
			<td>${libro.editorial}<%-- libro.getEditorial() --%></td>
			<td>${libro.precio}<%-- libro.getPrecio() --%></td>
		</tr>
		</c:forEach> 
	</table>
</section>
<section>
	<nav>
		<ul>
			<li><a href="formulario.jsp">Nuevo libro</a></li>
		</ul>
	</nav>
</section>
</body>
</html>