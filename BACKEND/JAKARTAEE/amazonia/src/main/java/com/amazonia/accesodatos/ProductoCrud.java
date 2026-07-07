package com.amazonia.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.amazonia.dtos.Producto;

import bibliotecas.accesodatos.BaseDeDatos;

public class ProductoCrud {
	public static ArrayList<Producto> obtenerTodos() {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT * FROM productos");
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Producto> productos = new ArrayList<Producto>();

			while (rs.next()) {
				Producto producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getBigDecimal("precio"));
				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener los productos", e);
		}
	}

	public static Producto obtenerPorId(Long id) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT * FROM productos WHERE id=?")) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getBigDecimal("precio"));
			}

			return producto;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el producto " + id, e);
		}
	}

	public static void borrar(Long id) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("DELETE FROM productos WHERE id=?")) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error al borrar el producto " + id, e);
		}
	}
}
