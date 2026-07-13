package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Factura.Linea;
import com.amazonia.dtos.Producto;
import com.amazonia.dtos.Usuario;
import com.amazonia.presentacion.modelos.Carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/facturar")
public class FacturarControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(FacturarControladorServlet.class.getName());

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		HttpSession session = request.getSession();
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		// 2. Convertir los datos
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		System.out.println("FACTURAR CONTROLADOR");

		System.out.println("TABLA facturas");
		System.out.println("Cliente ID");
		System.out.println(usuario);
		System.out.println("Calculamos número y fecha de factura");
		System.out.println("TABLA facturas_tiene_productos");
		System.out.println("Producto ID");
		System.out.println("Cantidad");
		System.out.println(carrito);
		System.out.println("Después se vacía carrito");
		
		System.out.println("Recibimos una factura");
		
		Producto producto1 = new Producto(1L, "PORTÁTIL", null, new BigDecimal("1234"));
		Producto producto2 = new Producto(2L, "MONITOR", null, new BigDecimal("123"));
		
		Linea linea1 = new Linea(producto1, 2);
		Linea linea2 = new Linea(producto2, 5);
		
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		lineas.add(linea1);
		lineas.add(linea2);
		
		Cliente cliente = new Cliente(2L, "Pepe", "Pérez", "12345678Z");
		
		Factura factura = new Factura(1L, "2026-0002", LocalDate.now(), cliente, lineas);
		
		System.out.println(factura);
		
		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("factura", factura);
		
		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("factura.jsp").forward(request, response);
	}

}
