package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(LogoutControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		HttpSession session = request.getSession();
		
		log.info("Cerrando sesión de " + session.getAttribute("usuario"));
		
		session.invalidate();
		
		log.info("Se ha cerrado la sesión");
		
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect("login");
	}
}
