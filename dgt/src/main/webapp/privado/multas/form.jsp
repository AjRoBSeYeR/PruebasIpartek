<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<main role="main" class="container">
<form action="privado/multas" method="post">
	<input type="hidden" name="idmulta" value="${(op == 'ver') ? multa.id : 0}">
	<input type="hidden" name="idcoche" value="${coche.id}">
	<input type="hidden" name="op" value="multar">
	<div class="form-group">
		<label for="matricula">Matricula</label> <input type="text" name="matricula"
			value="${(op == 'ver') ? multa.coche.matricula : coche.matricula}" class="form-control" readonly>
	</div>
	<div class="form-group">
		<label for="fecha">Fecha</label> <input type="text" name="fecha"
			value="<fmt:formatDate pattern = "dd/MM/yyyy HH:MM" value = "${(op == 'ver') ? multa.fecha : fecha}" />"
			class="form-control" readonly>
	</div>
	<div class="form-group">
		<span>Detalles del vehiculo</span>
	</div>
	<div class="form-group">
		<label for="modelo">Modelo</label> <input type="text" name="modelo"
			value="${(op == 'ver') ? multa.coche.modelo : coche.modelo}" class="form-control" readonly>
	</div>
	<div class="form-group">
		<label for="km">KM</label> <input type="text" name="km"
			value="${(op == 'ver') ? multa.coche.km : coche.km}" class="form-control" readonly>
	</div>
	<div class="form-group">
		<label for="concepto">Concepto</label> <input type="text"
			name="concepto" value="${(op == 'ver') ? multa.concepto : ''}" ${(op == 'ver') ? '' :'autofocus'} class="form-control"
			${(op == 'ver') ? "readonly" : ""}>
	</div>
	<div class="form-group">
		<label for="importe">Importe</label> <input type="number"
			name="importe" value="${(op == 'ver') ? multa.importe : ''}" class="form-control"
			${(op == 'ver') ? "readonly" : ""}>
	</div>
	<c:if test="${op == 'buscar'}">
		<a href="privado/multas?op=ir_a" class="btn btn-outline-primary btn-block">Cambiar de
			Vehiculo</a>
	
		<input type="submit" class="btn btn-outline-success btn-block mt-3 mb-3" value="Guardar multa">
		
	</c:if>
	<c:if test="${op != 'buscar'}">
	<a href="privado/multas?op=ver" class="btn btn-outline-primary btn-block mt-3 mb-3">Volver a la lista</a>
	<a href="#" class="btn btn-outline-danger btn-block mt-3 mb-3">Anular multa</a>
	</c:if>
	
	<a href="index.jsp" class="btn btn-outline-primary btn-block">Volver al inicio</a>
	

</form>
</main>
<%@ include file="../../includes/footer.jsp"%>