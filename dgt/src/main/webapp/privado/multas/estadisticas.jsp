<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<main role="main" class="container p-4">
<div class="container mb-3">
	<div class="row d-flex align-items-center mb-3">
		<div class="col-4">
			<a href="privado/principal.jsp"	class=" btn btn-outline-primary btn-block">Volver</a>
		</div>
		<div class="text-center align-middle col-8">
			<span style="font-size:25px">ESTAD�STICAS</span>
		</div>
	</div>
	<!-- Actual -->
	<span>A�o ${anyoActual}</span>
	<table id="actual" class="table">
		<tr>
			<td>Mes</td>
			<td>${totalMes} de ${objetivoAnual / 12}</td>
		</tr>
		<tr>
			<td>A�o</td>
			<td>${totalAnual} de ${objetivoAnual}</td>
		</tr>
	</table>
	
	<hr>
	
	<!-- Hist�rico -->
	<span>Hist�rico</span>
	<table id="historico" class="table">
		<thead class="thead-light">
			<tr>
				<th>Mes</th>
				<th>Rec de Obj</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${objetivo}" var="o">
				<tr class="${(o.importe < (objetivoAnual / 12)) ? 'nocumple' : 'cumple'}">
					<td>${o.mes}</td>
					<td>${o.importe} de ${objetivoAnual / 12}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 	
</div>

</main>
<%@include file="../../includes/footer.jsp"%>