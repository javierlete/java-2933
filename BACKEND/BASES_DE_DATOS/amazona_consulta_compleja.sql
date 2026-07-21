SELECT c.nombre, SUM(precio * cantidad) AS TOTAL, 
	CASE
		WHEN SUM(precio * cantidad) >= 5000 THEN 'VIP'
        WHEN SUM(precio * cantidad) >= 1500 THEN 'PREMIUM'
        /* ELSE 'NORMAL' */
	END AS CATEGORIA
FROM productos p
JOIN facturas_tiene_productos fp ON p.id = fp.productos_id
JOIN facturas f ON f.id = fp.facturas_id
JOIN clientes c ON c.id = f.clientes_id
WHERE c.nombre <> 'Javier'
GROUP BY c.nombre
/* HAVING TOTAL >= 1500 */ -- Después de los grupos
ORDER BY TOTAL DESC
LIMIT 5;
