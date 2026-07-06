package accesodatos;

import static bibliotecas.accesodatos.BaseDeDatos.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dtos.Rol;

public class RolCrud {
	private static final String SQL_SELECT = "SELECT * FROM roles";

	public static ArrayList<Rol> obtenerTodos() {
		try (PreparedStatement pst = crearSentencia(SQL_SELECT); ResultSet rs = pst.executeQuery()) {
			ArrayList<Rol> roles = new ArrayList<>();

			while (rs.next()) {
				Rol rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));

				roles.add(rol);
			}

			return roles;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido leer el listado", e);
		}
	}
}
