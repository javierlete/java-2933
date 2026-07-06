<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Mantenimiento de usuarios</title>
</head>
<body>
	<h1>Mantenimiento de usuarios</h1>

	<form action="usuario" method="post">
		<input name="id" placeholder="Id" value="${usuario.id}"> <input
			name="nombre" placeholder="Nombre" value="${usuario.nombre}">
		<input name="email" placeholder="Email" value="${usuario.email}">
		<input name="password" placeholder="Contraseña">

		<button>Guardar</button>
	</form>

</body>
</html>