package basesdedatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEjemplo {
	private static final String URL = "jdbc:sqlite:basicos.db";

	private static final String SQL_SELECT = "SELECT * FROM productos"; // "Órdenes al conductor"
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?"; // "Órdenes al conductor"
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES (?,?)"; // "Órdenes al
																									// conductor"
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE id=?"; // "Órdenes al
																									// conductor"
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?"; // "Órdenes al conductor"

	private static Connection con;

	public static void main(String[] args) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(URL); // "Carretera"

			listado("SELECT");

			// System.out.print("Dime el id: ");
			Long id = Long.parseLong("2"); // sc.nextLine());

			pst = con.prepareStatement(SQL_SELECT_ID);

			pst.setLong(1, id);

			rs = pst.executeQuery(); // "Cargamento"

			while (rs.next()) { // De uno en uno mientras haya carga que procesar
				System.out.printf("%2s %-10s %5s\n", rs.getString("id"), rs.getString("nombre"),
						rs.getString("precio"));
			}

			rs.close();
			pst.close();

			pst = con.prepareStatement(SQL_INSERT);

			pst.setString(1, "NUEVO");
			pst.setBigDecimal(2, new BigDecimal("1234.12"));

			pst.executeUpdate();

			pst.close();

			listado("INSERT");

			pst = con.prepareStatement(SQL_UPDATE);

			pst.setString(1, "MODIFICADO");
			pst.setBigDecimal(2, new BigDecimal("4321.21"));
			pst.setLong(3, 5);

			pst.executeUpdate();

			pst.close();

			listado("UPDATE");

			pst = con.prepareStatement(SQL_DELETE);

			pst.setLong(1, 5);

			pst.executeUpdate();

			pst.close();

			listado("DELETE");

			resetearId();

		} catch (NumberFormatException e) {
			System.out.println("No se ha podido convertir el texto a número");
		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos");
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar el ResultSet");
				}
			}
			
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar la sentencia");
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar la conexión");
				}
			}
		}
	}

	private static void listado(String titulo) throws SQLException {
		System.out.println("-----------------");
		System.out.println(titulo);
		System.out.println("-----------------");
		System.out.println();

		Statement st = con.createStatement(); // "Camión"
		ResultSet rs = st.executeQuery(SQL_SELECT); // "Cargamento"

		while (rs.next()) { // De uno en uno mientras haya carga que procesar
			System.out.printf("%2d %-20s %,10.2f €\n", rs.getLong("id"), rs.getString("nombre"),
					rs.getBigDecimal("precio"));
		}

		rs.close();
		st.close();

		System.out.println();
		System.out.println("FIN " + titulo);
		System.out.println("-----------------");
		System.out.println();
	}

	private static void resetearId() throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("UPDATE sqlite_sequence SET seq=4 WHERE name='productos'");

		st.close();
	}
}
