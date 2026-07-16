package com.amazonia.presentacion.controladores;

import java.io.IOException;

import com.amazonia.dtos.Factura;
import com.amazonia.logicanegocio.ClienteNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/factura")
public class FacturaControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");

		// 2. Convertir los datos
		Long id = Long.parseLong(sId);

		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		Factura factura = ClienteNegocio.verFactura(id);
		
		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("factura", factura);

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("factura.jsp").forward(request, response);
	}
}
