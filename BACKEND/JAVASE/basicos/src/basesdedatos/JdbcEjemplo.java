package basesdedatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEjemplo {
	public static void main(String[] args) throws SQLException {
//		Scanner sc = new Scanner(System.in);

		String url = "jdbc:sqlite:basicos.db";

		String sqlSelect = "SELECT * FROM productos"; // "Órdenes al conductor"
		String sqlSelectId = "SELECT * FROM productos WHERE id=?"; // "Órdenes al conductor"
		String sqlInsert = "INSERT INTO productos (nombre, precio) VALUES (?,?)"; // "Órdenes al conductor"
		String sqlUpdate = "UPDATE productos SET nombre=?, precio=? WHERE id=?"; // "Órdenes al conductor"
		String sqlDelete = "DELETE FROM productos WHERE id=?"; // "Órdenes al conductor"

		Connection con = DriverManager.getConnection(url); // "Carretera"
		
		listado("SELECT", con, sqlSelect);

		//System.out.print("Dime el id: ");
		Long id = Long.parseLong("2"); //sc.nextLine());

		PreparedStatement pst = con.prepareStatement(sqlSelectId);

		pst.setLong(1, id);

		ResultSet rs = pst.executeQuery(); // "Cargamento"

		while (rs.next()) { // De uno en uno mientras haya carga que procesar
			System.out.printf("%2s %-10s %5s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		}

		pst = con.prepareStatement(sqlInsert);
		
		pst.setString(1, "NUEVO");
		pst.setBigDecimal(2, new BigDecimal("1234.12"));
		
		pst.executeUpdate();

		listado("INSERT", con, sqlSelect);
		
		pst = con.prepareStatement(sqlUpdate);
		
		pst.setString(1, "MODIFICADO");
		pst.setBigDecimal(2, new BigDecimal("4321.21"));
		pst.setLong(3, 5);
		
		pst.executeUpdate();
		
		listado("UPDATE", con, sqlSelect);
		
		pst = con.prepareStatement(sqlDelete);
		
		pst.setLong(1, 5);
		
		pst.executeUpdate();

		listado("DELETE", con, sqlSelect);
		
		resetearId(con);
	}

	private static void listado(String titulo, Connection con, String sqlSelect) throws SQLException {
		System.out.println("-----------------");
		System.out.println(titulo);
		System.out.println("-----------------");
		System.out.println();
		
		Statement st = con.createStatement(); // "Camión"
		ResultSet rs = st.executeQuery(sqlSelect); // "Cargamento"

		while (rs.next()) { // De uno en uno mientras haya carga que procesar
			System.out.printf("%2s %-10s %5s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		}
		
		System.out.println();
	}

	private static void resetearId(Connection con) throws SQLException {
		Statement st = con.createStatement();
		st.executeUpdate("UPDATE sqlite_sequence SET seq=4 WHERE name='productos'");
	}
}
