package com.amazonia.presentacion.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AnonimoNegocio;
import com.amazonia.presentacion.modelos.Carrito;
import com.amazonia.presentacion.modelos.Linea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carrito/anadir")
public class AnadirCarritoControladorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(AnadirCarritoControladorServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de la petición
		HttpSession session = request.getSession();
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		
		String sId = request.getParameter("id");
		String sCantidad = request.getParameter("cantidad");
		
		// 2. Convertir los datos
		Long id = Long.parseLong(sId);
		Integer cantidad = Integer.parseInt(sCantidad);
		
		// 3. Crear un objeto con ellos
		// 4. Llamar a la lógica de negocio
		Producto producto = AnonimoNegocio.verDetalleProducto(id);
		
		log.info("Producto: " + producto);
		
		agregarProductoACarrito(carrito, producto, cantidad);
		
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect(request.getContextPath() + "/carrito");
	}

	private Carrito agregarProductoACarrito(Carrito carrito, Producto producto, Integer cantidad) {
		for(Linea linea: carrito.lineas()) {
			if(linea.producto().id() == producto.id()) {
				cantidad += linea.cantidad();
				
				carrito.lineas().remove(linea);
				
				break;
			}
		}
		
		carrito.lineas().add(new Linea(producto, cantidad));
		
		return carrito;
	}

}
