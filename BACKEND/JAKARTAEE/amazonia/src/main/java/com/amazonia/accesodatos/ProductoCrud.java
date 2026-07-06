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
			throw new RuntimeException("Error al obtener los productos");
		}
	}
}
