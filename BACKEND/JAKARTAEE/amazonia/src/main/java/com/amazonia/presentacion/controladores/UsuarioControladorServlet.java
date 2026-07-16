package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.ClienteNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/usuario")
public class UsuarioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		if (usuario.cliente() != null) {
			ArrayList<Factura> facturas = ClienteNegocio.listarFacturas(usuario.cliente().id());

			// 5. Empaquetar la información para la siguiente vista
			request.setAttribute("facturas", facturas);
		}

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/usuario.jsp").forward(request, response);
	}
}
