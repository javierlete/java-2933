package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import com.amazonia.dtos.Usuario;
import com.amazonia.logicanegocio.AnonimoNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(LoginControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String email= request.getParameter("email");
		String password= request.getParameter("password");

		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		Usuario login = new Usuario(null, null, email, password, null, null);

		// 4. Llamar a la lógica de negocio
		Usuario usuarioAutenticado = AnonimoNegocio.autenticar(login);
		
		if(usuarioAutenticado != null) {
			log.info("Login correcto");
			
			// 5. Empaquetar la información para la siguiente vista
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuarioAutenticado);
			
			// 6. Saltar a la siguiente vista
			response.sendRedirect("index");
		} else {
			log.warning("Login incorrecto");

			// 5. Empaquetar la información para la siguiente vista
			// 6. Saltar a la siguiente vista
			response.sendRedirect("login");
		}
		
	}

}
