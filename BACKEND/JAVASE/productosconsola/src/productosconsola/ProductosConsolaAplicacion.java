package productosconsola;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static bibliotecas.Consola.*;

public class ProductosConsolaAplicacion {
	private static final int OPCION_SALIR = 0;

	private static final String JDBC_URL = "jdbc:sqlite:productosconsola.db";

	private static final String FORMATO_CABECERAS = "%2s %-20s %12s\n";
	private static final String FORMATO_LINEA = "%2d %-20s %,10.2f €\n";
	private static final String FORMATO_REGISTRO = "%6s: %s\n";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	private static Connection con = null;

	public static void main(String[] args) {
		try {
			con = DriverManager.getConnection(JDBC_URL);

			int opcion;

			do {
				mostrarMenu();

				opcion = pedirOpcion();

				System.out.println();

				procesarOpcion(opcion);

				System.out.println();
			} while (opcion != OPCION_SALIR);

		} catch (NumberFormatException | SQLException e) {
			System.out.println("Error no controlado en la aplicación");
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Ha habido un error al cerrar la conexión");
				}
			}
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
		return pedirInt("Selecciona una opción: ");
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

		try (PreparedStatement pst = con.prepareStatement(SQL_SELECT); ResultSet rs = pst.executeQuery()) {
			mostrarListado(rs);
		} catch (SQLException e) {
			System.out.println("Error al hacer el listado");
		}
	}

	private static void buscarPorId() {
		System.out.println("BUSCAR POR ID\n");

		Long id = pedirLong("Dime el id");

		System.out.println();

		try (PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					mostrarRegistro(rs);
				} else {
					System.out.println("No se ha encontrado el id " + id);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el producto por id");
		}
	}

	private static void insertar() {
		System.out.println("INSERTAR\n");

		String nombre = pedirString("Nombre");
		BigDecimal precio = pedirBigDecimal("Precio");

		try (PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {

			pst.setString(1, nombre);
			pst.setBigDecimal(2, precio);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados == 1) {
				System.out.println("Inserción correcta");
			} else {
				System.out.println("Se han modificado " + numeroRegistrosModificados);
			}
		} catch (SQLException e) {
			System.out.println("Error al hacer la inserción");
		}
	}

	private static void modificar() {
		System.out.println("MODIFICAR\n");

		Long id = pedirLong("Id");
		String nombre = pedirString("Nombre");
		BigDecimal precio = pedirBigDecimal("Precio");

		try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, nombre);
			pst.setBigDecimal(2, precio);
			pst.setLong(3, id);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados == 1) {
				System.out.println("Modificación correcta");
			} else {
				System.out.println("Se han modificado " + numeroRegistrosModificados);
			}
		} catch (SQLException e) {
			System.out.println("Error al hacer la modificación");
		}
	}

	private static void borrar() {
		System.out.println("BORRAR\n");

		Long id = pedirLong("Id");

		try (PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setLong(1, id);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados == 1) {
				System.out.println("Borrado correcto");
			} else {
				System.out.println("Se han modificado " + numeroRegistrosModificados);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar el borrado");
		}
	}

	private static void mostrarListado(ResultSet rs) throws SQLException {
		mostrarCabeceras();

		while (rs.next()) {
			mostrarLinea(rs);
		}
	}

	private static void mostrarCabeceras() {
		System.out.printf(FORMATO_CABECERAS, "Id", "Nombre", "Precio");
		System.out.printf(FORMATO_CABECERAS, "--", "------", "------");
	}

	private static void mostrarLinea(ResultSet rs) throws SQLException {
		System.out.printf(FORMATO_LINEA, rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"));
	}

	private static void mostrarRegistro(ResultSet rs) throws SQLException {
		System.out.printf(FORMATO_REGISTRO, "Id", rs.getLong("id"));
		System.out.printf(FORMATO_REGISTRO, "Nombre", rs.getString("nombre"));
		System.out.printf(FORMATO_REGISTRO, "Precio", rs.getBigDecimal("precio"));
	}
}
