package com.amazonia.presentacion.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/formulario")
public class FormularioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");

		// 2. Convertir los datos
		if (sId != null) {
			Long id = Long.parseLong(sId);

			// 3. Crear un objeto con ellos
			// 4. Llamar a la lógica de negocio
			Producto producto = AnonimoNegocio.verDetalleProducto(id);

			// 5. Empaquetar la información para la siguiente vista
			request.setAttribute("producto", producto);
		}

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/admin/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");

		// 2. Convertir los datos
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);

		// 3. Crear un objeto con ellos
		Producto producto = new Producto(id, nombre, descripcion, precio);

		// 4. Llamar a la lógica de negocio
		if (id == null) {
			AdministradorNegocio.altaProducto(producto);
		} else {
			AdministradorNegocio.modificarProducto(producto);
		}

		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect("listado");
	}

}
