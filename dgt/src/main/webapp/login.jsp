<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<main role="main" class="container p-4">
	<form novalidate class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">
			Iniciar Sesi�n
		</h1>
		<label for="placa" class="sr-only">N� Placa
				</label> 
				<input type="text" id="placa"
			name="placa" class="form-control" placeholder="N� Placa"
			value="${usuario}" required autofocus>
			<label for="password" class="sr-only">
			Contrase�a:</label> 
			<input type="password" id="password" class="form-control" placeholder="Contrase�a" name="password" value="${password}"
			required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Acceder
		</button>
		<%@include file="includes/mensajes.jsp"%>
	</form>
</main>
<%@include file="includes/footer.jsp"%>