<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container p-4"> 
	<form action="privado/multas" method="post">
		<div class="row align-items-center">
		<a href="login" class="btn btn-outline-primary mt-3 mb-3 col-3">
			Volver
		</a>
		</div>
		<%@ include file="../../includes/mensajes.jsp"%>
		<input type="hidden" name="op" value="buscar">
			<div class="form-group">
				<label for="matricula">Introducir Matricula a multar</label> <input type="text" name="matricula" class="form-control" placeholder="4 numeros, 3 letras" value="${matricula}" required>
			</div>
			<button type="submit" class="btn btn-outline-primary btn-block">BUSCAR</button>
	</form>
</main>
<%@ include file="../../includes/footer.jsp"%>