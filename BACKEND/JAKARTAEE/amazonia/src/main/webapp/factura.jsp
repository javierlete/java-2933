<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>

<h2>Factura</h2>

<div class="d-flex justify-content-between">
	<h3>Factura número: 2026-0001</h3>
	<h3>Fecha: 13/07/2026</h3>
</div>

<div class="row row-cols-md-2 mb-5">
	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Emisor</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Amazonia</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">CIF:
					B91234567</h6>
				<p class="card-text">C/Su calle n.25</p>
				<p class="card-text">C.P.: 12345</p>
				<p class="card-text">Madrid</p>
			</div>
		</div>
	</div>

	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Factura a</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Javier Lete</h6>
				<h6 class="card-subtitle mb-2 text-body-secondary">NIF:
					12345678Z</h6>
				<p class="card-text">C/Mi calle n.1</p>
				<p class="card-text">C.P.: 48000</p>
				<p class="card-text">Bilbao</p>
			</div>
		</div>
	</div>
</div>

<div class="table-responsive">
	<div class="card">
		<div class="card-body">
			<table class="table table-borderless">
				<caption>Carrito</caption>

				<thead>
					<tr>
						<th>Nombre</th>
						<th class="text-end">Precio</th>
						<th class="text-center">Cantidad</th>
						<th class="text-end d-none d-md-table-cell">Subtotal</th>
						<th class="text-end d-none d-md-table-cell">IVA</th>
						<th class="text-end">Total</th>
					</tr>
				</thead>

				<tbody>
					<tr class="align-middle">
						<td>Portátil</td>
						<td class="text-end">1.210,00 €</td>
						<td class="text-center">2</td>
						<td class="text-end d-none d-md-table-cell">2.000,00€</td>
						<td class="text-end d-none d-md-table-cell">420,00 €</td>
						<td class="text-end fw-bold">2.420,00€</td>
					</tr>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">Subtotal</td>
						<td class="text-end">2.000,00 €</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">IVA</td>
						<td class="text-end">420,00 €</td>
					</tr>
					<tr class="fw-bold">
						<td colspan="2"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="d-none d-md-table-cell"></td>
						<td class="text-end">Total</td>
						<td class="text-end">2.420,00 €</td>
					</tr>

				</tfoot>

			</table>
		</div>
	</div>
</div>
<%@ include file="/includes/pie.jsp"%>