package com.amazonia.logicanegocio;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodatos.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AnonimoNegocio {
	private static final Logger log = Logger.getLogger(AnonimoNegocio.class.getName());
	
	public static ArrayList<Producto> listarProductos() {
		log.info("Listando productos");
		
		return ProductoCrud.obtenerTodos();
	}
	
	public static Producto verDetalleProducto(Long id) {
		log.info("Ver detalle producto " + id);
		
		return ProductoCrud.obtenerPorId(id);
	}

}
