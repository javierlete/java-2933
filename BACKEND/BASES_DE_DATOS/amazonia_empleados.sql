SELECT *
FROM empleados e
LEFT JOIN empleados j ON j.id=e.jefe_id