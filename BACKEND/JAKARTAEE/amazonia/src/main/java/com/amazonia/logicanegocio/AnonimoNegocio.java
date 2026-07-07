package com.amazonia.logicanegocio;

import java.util.ArrayList;

import com.amazonia.accesodatos.ProductoCrud;
import com.amazonia.dtos.Producto;

public class AnonimoNegocio {
	public static ArrayList<Producto> listarProductos() {
		System.out.println("Listando productos");
		
		return ProductoCrud.obtenerTodos();
	}
}
