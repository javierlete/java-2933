package com.amazonia.accesodatos;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;

public class FacturaCrud {

	public static Factura insertar(Factura facturaProvisional) {
		Cliente cliente = new Cliente(2L, "Pepe", "Pérez", "12345678Z");

		Factura factura = new Factura(1L, "2026-0002", facturaProvisional.fecha(), cliente,
				facturaProvisional.lineas());

		return factura;
	}

}
