package basesdedatos;

import java.sql.*;

public class JdbcEjemplo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlite:basicos.db";

		String sqlSelect = "SELECT * FROM productos"; // "Órdenes al conductor"

		Connection con = DriverManager.getConnection(url); // "Carretera"
		Statement st = con.createStatement(); // "Camión"
		ResultSet rs = st.executeQuery(sqlSelect); // "Cargamento"

		while (rs.next()) { // De uno en uno mientras haya carga que procesar
			System.out.printf("%2s %-10s %5s\n", rs.getString("id"), rs.getString("nombre"), rs.getString("precio"));
		}
	}
}
