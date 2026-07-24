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

	public static ArrayList<Producto> listarProductos(Integer pagina) {
		log.info("Listando productos " + pagina);

		return ProductoCrud.obtenerPagina(pagina);
	}

	public static ArrayList<Producto> listarProductos(Integer pagina, String texto) {
		log.info("Listando productos página " + pagina + " buscando texto " + texto);

		if (pagina != null && texto != null) {
			return ProductoCrud.obtenerPagina(pagina, texto);
		}

		if (pagina != null && texto == null) {
			return ProductoCrud.obtenerPagina(pagina);
		}

		if (pagina == null && texto != null) {
			return ProductoCrud.obtenerPagina(1, texto);
		}
		
		return ProductoCrud.obtenerPagina(1);
	}

	public static int numeroPaginasProductos() {
		return ProductoCrud.obtenerNumeroPaginas();
	}

	public static int numeroPaginasProductos(String texto) {
		return ProductoCrud.obtenerNumeroPaginas(texto);
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

	public static ArrayList<Producto> buscarProductos(String texto) {
		log.info("Búsqueda por " + texto);

		return ProductoCrud.obtenerPorTexto(texto);
	}
}
