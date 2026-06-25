package presentacion;

import static bibliotecas.Consola.pedirBigDecimal;
import static bibliotecas.Consola.pedirInt;
import static bibliotecas.Consola.pedirLong;
import static bibliotecas.Consola.pedirString;

import java.math.BigDecimal;
import java.util.ArrayList;

import accesodatos.ProductoCrud;
import dtos.Producto;

public class ProductosConsolaAplicacion {
	private static final int OPCION_SALIR = 0;

	private static final String FORMATO_CABECERAS = "%2s %-20s %12s\n";
	private static final String FORMATO_LINEA = "%2d %-20s %,10.2f €\n";
	private static final String FORMATO_REGISTRO = "%6s: %s\n";

	public static void main(String[] args) {
		try {
			int opcion;

			do {
				mostrarMenu();

				opcion = pedirOpcion();

				System.out.println();

				try {
					procesarOpcion(opcion);
				} catch (Exception e) {
					System.out.println("Error en la operación de base de datos");
					System.out.println(e.getMessage());
				}

				System.out.println();
			} while (opcion != OPCION_SALIR);

		} catch (Exception e) {
			System.out.println("Error no controlado en la aplicación");
			System.out.println(e.getMessage());
		}
	}

	private static void mostrarMenu() {
		System.out.println("""
				MENU
				====

				1. Listado
				2. Buscar por id

				3. Insertar
				4. Modificar
				5. Borrar

				0. Salir

				""");
	}

	private static int pedirOpcion() {
		return pedirInt("Selecciona una opción");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			System.out.println("Gracias por usar el programa");
			break;
		default:
			System.out.println("Opción no reconocida");
		}
	}

	private static void listado() {
		System.out.println("LISTADO\n");

		ArrayList<Producto> productos = ProductoCrud.obtenerTodos();

		mostrarListado(productos);
	}

	private static void buscarPorId() {
		System.out.println("BUSCAR POR ID\n");

		Long id = pedirLong("Dime el id");

		System.out.println();

		Producto producto = ProductoCrud.obtenerPorId(id);

		if (producto != null) {
			mostrarProducto(producto);
		} else {
			System.out.println("No se ha encontrado el id " + id);
		}
	}

	private static void insertar() {
		System.out.println("INSERTAR\n");
	
		String nombre = pedirString("Nombre");
		BigDecimal precio = pedirBigDecimal("Precio");
	
		Producto producto = new Producto(null, nombre, precio);
		
		ProductoCrud.insertar(producto);
		
		System.out.println("Inserción correcta");
	}

	private static void modificar() {
		System.out.println("MODIFICAR\n");

		Long id = pedirLong("Id");
		String nombre = pedirString("Nombre");
		BigDecimal precio = pedirBigDecimal("Precio");

		Producto producto = new Producto(id, nombre, precio);

		ProductoCrud.modificar(producto);

		System.out.println("Modificación correcta");
	}

	private static void borrar() {
		System.out.println("BORRAR\n");

		Long id = pedirLong("Id");

		ProductoCrud.borrar(id);

		System.out.println("Borrado correcto");
	}

	private static void mostrarListado(ArrayList<Producto> productos) {
		mostrarCabeceras();

		for(Producto producto: productos) {
			mostrarLinea(producto);
		}
	}

	private static void mostrarCabeceras() {
		System.out.printf(FORMATO_CABECERAS, "Id", "Nombre", "Precio");
		System.out.printf(FORMATO_CABECERAS, "--", "------", "------");
	}

	private static void mostrarLinea(Producto producto) {
		System.out.printf(FORMATO_LINEA, producto.id(), producto.nombre(), producto.precio());
	}

	private static void mostrarProducto(Producto producto) {
		System.out.printf(FORMATO_REGISTRO, "Id", producto.id());
		System.out.printf(FORMATO_REGISTRO, "Nombre", producto.nombre());
		System.out.printf(FORMATO_REGISTRO, "Precio", producto.precio());
	}

	
}
