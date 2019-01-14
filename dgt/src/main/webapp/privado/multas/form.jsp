<%@ include file="../../includes/header.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>
<main role="main" class="container p-4">
	<form action="privado/multas" method="post">
		<input type="hidden" name="idmulta" value="${(op == 'ver') ? multa.id : 0}">
		<input type="hidden" name="idcoche" value="${coche.id}">
		<input type="hidden" name="op" value="multar">
		<div class="form-group">
			<label for="matricula">Matricula</label> <input type="text" name="matricula"
				value="${(op == 'ver') ? multa.coche.matricula : coche.matricula}" class="form-control" readonly>
		</div>
		<c:choose>
			<c:when test="${opm != 'baja'}">
				<div class="form-group">
					<label for="fecha">Fecha</label> <input type="text" name="fecha"
						value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${(op == 'ver') ? multa.fechaAlta : fecha}" />"
						class="form-control" readonly>
				</div>
			</c:when>
			<c:otherwise>
				<div class="form-group">
					<label for="fecha">Fecha Alta</label> <input type="text" name="fechaAlta"
						value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${multa.fechaAlta}" />"
						class="form-control" readonly>
				</div>
				<div class="form-group">
					<label for="fecha">Fecha Baja</label> <input type="text" name="fechaBaja"
						value="<fmt:formatDate pattern = "dd/MM/yyyy HH:mm" value = "${multa.fechaBaja}" />"
						class="form-control" readonly>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="form-group">
				<label for="concepto">Concepto</label> <input type="text"
					name="concepto" value="${(op == 'ver') ? multa.concepto : concepto}" ${(op == 'ver') ? '' :'autofocus'} required class="form-control"
					${(op == 'ver') ? "readonly" : ""}>
		</div>
		<div class="form-group">
			<label for="importe">Importe</label> <input type="number" step="0.01" required
				name="importe" value="${(op == 'ver') ? multa.importe : importe}" class="form-control"
				${(op == 'ver') ? "readonly" : ""}>
		</div>
		<fieldset class="border p-2">
			<legend class="w-auto">Detalles del vehiculo</legend>
			<div class="form-group">
				<label for="modelo">Modelo</label> <input type="text" name="modelo"
					value="${(op == 'ver') ? multa.coche.modelo : coche.modelo}" class="form-control" readonly>
			</div>
			<div class="form-group">
				<label for="km">KM</label> <input type="text" name="km"
					value="${(op == 'ver') ? multa.coche.km : coche.km}" class="form-control" readonly>
			</div>
		</fieldset>
		<c:if test="${op == 'buscar'}">
			<a href="privado/multas?op=irA" class="mt-4 btn btn-outline-primary btn-block">
				Cambiar de Veh�culo
			</a>
			<input type="submit" class="btn btn-outline-success btn-block mt-3 mb-3" value="Multar">
		</c:if>
		
		<c:if test="${op != 'buscar'}">
			<a href="privado/multas?op=ver&opm=${opm}" class="btn btn-outline-primary btn-block mt-3 mb-3">
				Volver a la lista
			</a>
			<c:if test="${opm != 'baja'}">
			<!-- Button trigger modal -->
		
				<a href="#" class="btn btn-outline-danger btn-block mt-3 mb-3" data-toggle="modal" data-target="#exampleModal">Anular multa</a>
				
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
				    	<div class="modal-content">
				      		<div class="modal-header">
				        		<h5 class="modal-title" id="exampleModalLabel">Confirmaci�n de anulaci�n de multa</h5>
				        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          			<span aria-hidden="true">&times;</span>
				        		</button>
							</div>
							<div class="modal-body">
						       �Est� seguro de anular esta multa de la matricula ${multa.coche.matricula} con fecha ${multa.fechaAlta}?
							</div>
							<div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-dismiss="modal">No anular</button>
						        <a href="privado/multas?op=anular&idmulta=${multa.id}"  class="btn btn-danger">
						        	Anular multa
						        </a>
							</div>
				    	</div>
					</div>
				</div>	
			</c:if>
		</c:if>
		<%@ include file="../../includes/mensajes.jsp"%>
		<a href="login" class="btn btn-outline-primary btn-block">Volver al inicio</a>
	</form>
</main>
<%@ include file="../../includes/footer.jsp"%>