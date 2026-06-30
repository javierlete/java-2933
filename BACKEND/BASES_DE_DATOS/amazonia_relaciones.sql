SELECT *
FROM usuarios u
JOIN roles r ON u.roles_id = r.id
LEFT JOIN clientes c ON u.clientes_id = c.id;

SELECT f.numero, f.fecha, c.nombre, c.apellidos, c.nif, p.nombre, p.precio, fp.cantidad
FROM clientes c
JOIN facturas f ON c.id = f.clientes_id
JOIN facturas_tiene_productos fp ON fp.facturas_id = f.id
JOIN productos p ON p.id = fp.productos_id
ORDER BY f.numero;