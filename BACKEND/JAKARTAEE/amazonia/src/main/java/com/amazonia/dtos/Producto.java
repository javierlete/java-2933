package com.amazonia.dtos;

import java.math.BigDecimal;

public record Producto(Long id, String nombre, String descripcion, BigDecimal precio) {

}
