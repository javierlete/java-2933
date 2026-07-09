<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>

<table class="table">
	<caption>Listado de productos</caption>

	<thead class="table-secondary">
		<tr>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr class="align-middle">
				<td>${producto.nombre}</td>
				<td class="text-end">${producto.precio}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<%@ include file="/includes/pie.jsp"%>