<%@page import="dtos.Usuario"%>
<%@page import="accesodatos.UsuarioCrud"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String borrar = request.getParameter("borrar");

System.out.println(borrar);

if (borrar != null) {
	Long id = Long.parseLong(borrar);
	UsuarioCrud.borrar(id);
}
%>

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
			for (Usuario usuario : UsuarioCrud.obtenerTodos()) {
			%>
			<tr>
				<th><%= usuario.id() %></th>
				<td><%= usuario.nombre() %></td>
				<td><%= usuario.email() %></td>
				<td><%= usuario.rolNombre() %></td>
				<td><a href="usuario.jsp?id=<%=usuario.id()%>">Editar</a> <a
					href="usuarios.jsp?borrar=<%=usuario.id()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="4"></td>
				<td><a href="usuario.jsp">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>