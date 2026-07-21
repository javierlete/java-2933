package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AnonimoNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(IndexControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sPagina = request.getParameter("pagina");
		
		// 2. Convertir los datos
		int pagina = sPagina == null ? 1 : Integer.parseInt(sPagina);
		
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		ArrayList<Producto> productos = AnonimoNegocio.listarProductos(pagina);
		int numeroPaginas = AnonimoNegocio.numeroPaginasProductos();
		
		log.info("Productos: " + productos);
		
		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("productos", productos);
		request.setAttribute("numeroPaginas", numeroPaginas);
		
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
