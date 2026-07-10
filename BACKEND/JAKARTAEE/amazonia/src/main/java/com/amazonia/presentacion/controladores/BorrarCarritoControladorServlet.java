package com.amazonia.presentacion.controladores;

import java.io.IOException;

import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carrito/borrar")
public class BorrarCarritoControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de la petición
		HttpSession session = request.getSession();
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		
		String sId = request.getParameter("id");
		
		// 2. Convertir los datos
		Long id = Long.parseLong(sId);
		
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		borrarProductoDeCarrito(carrito, id);
		
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect(request.getContextPath() + "/carrito");
	}

	private Carrito borrarProductoDeCarrito(Carrito carrito, Long id) {
		for(Linea linea: carrito.lineas()) {
			if(linea.producto().id() == id) {
				carrito.lineas().remove(linea);
				
				break;
			}
		}
		
		return carrito;
	}

}
