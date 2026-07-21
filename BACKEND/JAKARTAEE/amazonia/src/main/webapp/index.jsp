<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${productos}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">${p.descripcion}</p>
					<p class="card-text">
						<a class="btn btn-primary" href="detalle?id=${p.id}">Ver
							producto</a>
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary"> <fmt:formatNumber
							type="currency" value="${p.precio}" />
					</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<nav class="mt-3" aria-label="Navegación de páginas">
	<ul class="pagination justify-content-center">
		<!-- Ir al inicio (|<) -->
		<li class="page-item ${param.pagina == 1 ? 'disabled' : ''}"><a class="page-link" href="index?pagina=1"
			aria-label="Primero"> <i class="bi bi-chevron-bar-left"></i>
		</a></li>
		<!-- Anterior (<) -->
		<li class="page-item ${param.pagina == 1 ? 'disabled' : ''}"><a class="page-link" href="index?pagina=${param.pagina - 1}"
			aria-label="Anterior"> <i class="bi bi-chevron-left"></i>
		</a></li>

		<!-- Páginas Numéricas -->
		<li class="page-item"><a class="page-link" href="#">${param.pagina} de ${numeroPaginas}</a></li>

		<!-- Siguiente (>) -->
		<li class="page-item ${param.pagina == numeroPaginas ? 'disabled' : ''}"><a class="page-link" href="index?pagina=${param.pagina + 1}"
			aria-label="Siguiente"> <i class="bi bi-chevron-right"></i>
		</a></li>
		<!-- Ir al final (>|) -->
		<li class="page-item ${param.pagina == numeroPaginas ? 'disabled' : ''}"><a class="page-link" href="index?pagina=${numeroPaginas}"
			aria-label="Último"> <i class="bi bi-chevron-bar-right"></i>
		</a></li>
	</ul>
</nav>


<%@ include file="/includes/pie.jsp"%>