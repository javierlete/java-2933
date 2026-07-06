package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.amazonia.accesodatos.ProductoCrud;
import com.amazonia.dtos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de la petición
		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Procesar los datos
		ArrayList<Producto> productos = ProductoCrud.obtenerTodos();
		
		System.out.println("Productos: " + productos);
		
		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("productos", productos);
		
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
