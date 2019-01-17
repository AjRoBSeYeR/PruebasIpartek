<!doctype html>
<html lang="es">
	<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<title>${(titulo != null) ? titulo : 'P�gina'}</title>
	<base href="${pageContext.request.contextPath}/">
	<!-- Bootstrap core CSS -->
	<meta name="theme-color" content="#007bff">
	
	<meta name="msapplication-navbutton-color" content="#007bff">
	
	<link rel="stylesheet" href="css/datatables.css">
	<link rel="stylesheet" href="css/datatables-responsive.css">
	<link rel="stylesheet" href="css/estilos.css">
	
	<link rel="shortcut icon" type="image/x-icon" href="https://pngimage.net/wp-content/uploads/2018/05/escudo-policia-nacional-espa%C3%B1a-png-1.png"/>
		
	<link href="http://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
		rel="stylesheet">
		 <link href="https://getbootstrap.com/docs/4.1/examples/navbar-fixed/navbar-top-fixed.css" rel="stylesheet">
	</head>
<body>
<main role="main" class="container">
<div>
	<img class="img-responsive mx-auto d-block mb-5" width="175px"
		height="200px"
		src="https://pngimage.net/wp-content/uploads/2018/05/escudo-policia-nacional-espa%C3%B1a-png-1.png"
		alt="escudo policia">
</div>
<form novalidate class="form-signin" action="login" method="post">
	<h1 class="h3 mb-3 font-weight-normal text-center">Iniciar Sesi�n
	</h1>
	<label for="placa" class="sr-only">N� Placa </label> <input type="text"
		id="placa" name="placa" class="form-control number mb-3" maxlength="6"
		placeholder="N� Placa" value="${placa}" required autofocus> 
	<label for="password" class="sr-only"> Contrase�a:</label> <input
		type="password" id="password" class="form-control mb-3"
		placeholder="Contrase�a" name="password" value="${password}" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">
		Acceder</button>
	<%@include file="includes/mensajes.jsp"%>
</form>
</main>
  	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  	<script src="js/datatables.js"></script>
  	<script src="js/datatables-responsive.js"></script>
  	<script src="js/decimales.js"></script>
  	<script src="js/contadorTextarea.js"></script>
  </body>
</html>