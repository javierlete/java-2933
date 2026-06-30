package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dtos.Usuario;

public class UsuarioCrud {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/amazonia";
	private static final String JDBC_USER = "amazonia_app";
	private static final String JDBC_PASS = "app";

	public static ArrayList<Usuario> obtenerTodos() {
		try (PreparedStatement pst = crearSentencia("SELECT * FROM usuarios");
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"));
				
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido leer el listado", e);
		}
	}

	private static PreparedStatement crearSentencia(String sql) {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			PreparedStatement pst = con.prepareStatement(sql);
			
			return pst;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido conectar a la base de datos", e);
		}
	}

}
