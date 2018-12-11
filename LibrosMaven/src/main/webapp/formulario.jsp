<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
	<section>
		<% String id = request.getParameter("id");
		String est = request.getParameter("est");
		String act,txtbot;
		if ("n".equals(est)){
			act="altalibro";
			txtbot="Agregar";
		}
		if ("ed".equals(est)){
			act="editar";
			txtbot="Guardar";
		}
		%>
		<form action="${act}">
			<fieldset>
				<legend>Datos de libro</legend>
				<p>
					<label for="id">ID</label>
					<input name="id" id="id" type="text"/>
				</p>
				<p>
					<label for="isbn">ISBN</label>
					<input name="isbn" id="isbn" type="text"/>
				</p>
				<p>
					<label for="titulo">Titulo</label>
					<input name="titulo" id="titulo" type="text"/>
				</p>
				<p>
					<label for="autor">Autor</label>
					<input name="autor" id="autor" type="text"/>
				</p>
				<p>
					<label for="editorial">Editorial</label>
					<input name="editorial" id="editorial" type="text"/>
				</p>
				<p>
					<label for="precio">Precio</label>
					<input name="precio" id="precio" type="text"/>
				</p>
				<p>
					<button>${txtbot}</button>
				</p>
			</fieldset>
		</form>
	</section>
</body>
</html>