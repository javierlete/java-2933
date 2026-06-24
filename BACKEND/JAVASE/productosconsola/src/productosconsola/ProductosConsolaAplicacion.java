package productosconsola;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductosConsolaAplicacion {
	private static final String JDBC_URL = "jdbc:sqlite:productosconsola.db";
	
	private static final String FORMATO_CABECERAS = "%2s %-20s %12s\n";
	private static final String FORMATO_LINEA = "%2d %-20s %,10.2f €\n";
	private static final String FORMATO_REGISTRO = "%6s: %s\n";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(JDBC_URL);
				Scanner sc = new Scanner(System.in)) {

			int opcion;

			do {
				mostrarMenu();

				opcion = pedirOpcion(sc);

				System.out.println();

				procesarOpcion(con, sc, opcion);

				System.out.println();
			} while (opcion != 0);

		} catch (NumberFormatException | SQLException e) {
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

	private static int pedirOpcion(Scanner sc) {
		int opcion;
		System.out.print("Selecciona una opción: ");
		opcion = Integer.parseInt(sc.nextLine());
		return opcion;
	}

	private static void procesarOpcion(Connection con, Scanner sc, int opcion) {
		switch (opcion) {
		case 1:
			listado(con);
			break;
		case 2:
			buscarPorId(con, sc);
			break;
		case 3:
			insertar(con, sc);
			break;
		case 4:
			modificar(con, sc);
			break;
		case 5:
			borrar(con, sc);
			break;
		case 0:
			System.out.println("Gracias por usar el programa");
			break;
		default:
			System.out.println("Opción no reconocida");
		}
	}

	private static void listado(Connection con) {
		System.out.println("LISTADO\n");

		System.out.printf(FORMATO_CABECERAS, "Id", "Nombre", "Precio");
		System.out.printf(FORMATO_CABECERAS, "--", "------", "------");

		try (PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				System.out.printf(FORMATO_LINEA, rs.getLong("id"), rs.getString("nombre"),
						rs.getBigDecimal("precio"));
			}
		} catch (SQLException e) {
			System.out.println("Error al hacer el listado");
		}
	}

	private static void buscarPorId(Connection con, Scanner sc) {
		System.out.println("BUSCAR POR ID\n");

		System.out.print("Dime el id: ");
		Long id = Long.parseLong(sc.nextLine());

		System.out.println();

		try (PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					System.out.printf(FORMATO_REGISTRO, "Id", rs.getLong("id"));
					System.out.printf(FORMATO_REGISTRO, "Nombre", rs.getString("nombre"));
					System.out.printf(FORMATO_REGISTRO, "Precio", rs.getBigDecimal("precio"));
				} else {
					System.out.println("No se ha encontrado el id " + id);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el producto por id");
		}
	}

	private static void insertar(Connection con, Scanner sc) {
		System.out.println("INSERTAR\n");

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Precio: ");
		BigDecimal precio = new BigDecimal(sc.nextLine());

		try (PreparedStatement pst = con
				.prepareStatement(SQL_INSERT)) {

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

	private static void modificar(Connection con, Scanner sc) {
		System.out.println("MODIFICAR\n");

		System.out.print("Id: ");
		Long id = Long.parseLong(sc.nextLine());

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Precio: ");
		BigDecimal precio = new BigDecimal(sc.nextLine());

		try (PreparedStatement pst = con
				.prepareStatement(SQL_UPDATE)) {

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

	private static void borrar(Connection con, Scanner sc) {
		System.out.println("BORRAR\n");

		System.out.print("Id: ");
		Long id = Long.parseLong(sc.nextLine());

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
}
