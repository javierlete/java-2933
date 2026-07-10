<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>
	<i class="bi bi-cart"></i> Carrito
</h2>

<table class="table">
	<caption>Carrito</caption>

	<thead class="table-secondary">
		<tr>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th class="text-end">Cantidad</th>
			<th class="text-end">Subtotal</th>
			<th class="text-end">IVA</th>
			<th class="text-end">Total</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito.lineas}" var="linea">
			<tr class="align-middle">
				<td>${linea.producto.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.producto.precio}" /></td>
				<td class="text-end">${linea.cantidad}</td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.subTotal}" /></td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${linea.iva}" /></td>
				<td class="text-end fw-bold"><fmt:formatNumber type="currency"
						value="${linea.total}" /></td>
			</tr>
		</c:forEach>
	</tbody>

	<tfoot class="table-secondary">
		<tr>
			<td colspan="4"></td>
			<td class="text-end">Subtotal</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.subTotal}" /></td>
		</tr>
		<tr>
			<td colspan="4"></td>
			<td class="text-end">IVA</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.iva}" /></td>
		</tr>
		<tr class="fw-bold">
			<td colspan="4"></td>
			<td class="text-end">Total</td>
			<td class="text-end"><fmt:formatNumber type="currency"
					value="${carrito.total}" /></td>
		</tr>
	</tfoot>

</table>

<%@ include file="/includes/pie.jsp"%>