package com.amazonia.rest.v1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/productos/search/buscarPorNombre")
public class ProductoBuscarRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson GSON = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String nombre = request.getParameter("nombre");

		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		ArrayList<Producto> productos = AnonimoNegocio.buscarProductos(nombre);
		// 5. Convertir a JSON
		String json = GSON.toJson(productos);

		// 6. Devolver el resultado
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		out.println(json);
	}
}
