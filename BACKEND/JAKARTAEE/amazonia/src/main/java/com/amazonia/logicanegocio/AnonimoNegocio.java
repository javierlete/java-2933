package com.amazonia.logicanegocio;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodatos.ProductoCrud;
import com.amazonia.dtos.Producto;
import com.amazonia.dtos.Usuario;

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

	public static Usuario autenticar(Usuario login) {
		if( "javier@email.net".equals(login.email()) && "javier".equals(login.password())) {
			return new Usuario(1L, "Javier", "javier@email.net", "javier", "ADMINISTRADOR");
		} else {
			return null;
		}
	}
}
