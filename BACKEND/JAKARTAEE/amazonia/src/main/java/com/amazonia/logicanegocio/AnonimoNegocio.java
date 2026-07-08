package com.amazonia.logicanegocio;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.amazonia.accesodatos.ProductoCrud;
import com.amazonia.accesodatos.UsuarioCrud;
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
		Usuario usuario = UsuarioCrud.obtenerPorEmail(login.email());
		
		if (usuario != null && usuario.password().equals(login.password())) {
			return usuario;
		} else {
			return null;
		}
	}
}
