package com.amazonia.presentacion.controladores.admin;

import java.io.IOException;

import com.amazonia.dtos.Producto;
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

}
