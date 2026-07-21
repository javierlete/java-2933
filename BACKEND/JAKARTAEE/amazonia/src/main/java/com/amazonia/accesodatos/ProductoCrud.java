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

	public static ArrayList<Producto> obtenerPorTexto(String texto) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia("SELECT * FROM productos WHERE nombre LIKE ?")) {
			pst.setString(1, "%" + texto + "%");
			ResultSet rs = pst.executeQuery();

			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto producto = null;

			while (rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getBigDecimal("precio"));
				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar " + texto, e);
		}
	}

	public static void insertar(Producto producto) {
		try (PreparedStatement pst = BaseDeDatos
				.crearSentencia("INSERT INTO productos (nombre, precio, descripcion) VALUES (?,?,?)")) {
			pst.setString(1, producto.nombre());
			pst.setBigDecimal(2, producto.precio());
			pst.setString(3, producto.descripcion());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error al añadir el producto " + producto, e);
		}
	}

	public static void modificar(Producto producto) {
		try (PreparedStatement pst = BaseDeDatos
				.crearSentencia("UPDATE productos SET nombre=?, precio=?, descripcion=? WHERE id=?")) {
			pst.setString(1, producto.nombre());
			pst.setBigDecimal(2, producto.precio());
			pst.setString(3, producto.descripcion());
			pst.setLong(4, producto.id());

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error al modificar el producto " + producto, e);
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
