<%@page import="java.util.ArrayList"%>
<%@page import="dtos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Mantenimiento de usuarios</title>
</head>
<body>
	<h1>Mantenimiento de usuarios</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Rol</th>
				<th>OPCIONES</th>
			</tr>
		</thead>

		<tbody>
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
			
			for (Usuario usuario : usuarios) {
			%>
			<tr>
				<th><%=usuario.id()%></th>
				<td><%=usuario.nombre()%></td>
				<td><%=usuario.email()%></td>
				<td><%=usuario.rolNombre()%></td>
				<td><a href="usuario?id=<%=usuario.id()%>">Editar</a> <a
					href="usuarios?borrar=<%=usuario.id()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="4"></td>
				<td><a href="usuario">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>