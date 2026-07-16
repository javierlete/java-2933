package com.amazonia.presentacion.controladores;

import java.io.IOException;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.UsuarioNegocio;

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
		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nif = request.getParameter("nif");

		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		Cliente cliente = new Cliente(null, nombre, apellidos, nif);

		// 4. Llamar a la lógica de negocio
		Usuario usuarioConCliente = UsuarioNegocio.registrarCliente(usuario, cliente);
		
		// 5. Empaquetar la información para la siguiente vista
		session.setAttribute("usuario", usuarioConCliente);
		
		// 6. Saltar a la siguiente vista
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
