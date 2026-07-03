<%@page import="accesodatos.UsuarioCrud"%>
<%@page import="dtos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuario = new Usuario(0L, "", "", "", 0L, "");

if (request.getMethod().equals("GET")) {

	String strId = request.getParameter("id");

	if (strId != null) {
		Long id = Long.parseLong(strId);

		usuario = UsuarioCrud.obtenerPorId(id);
	}
} else {
	// 1. Recibir la información de la petición
	String strId = request.getParameter("id");
	String nombre = request.getParameter("nombre");
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	// 2. Convertir los datos necesarios
	Long id = Long.parseLong(strId);

	// 3. Crear objeto
	usuario = new Usuario(id, nombre, email, password, 2L, null);

	// 4. Hacer lo que sea con él
	if (usuario.id() == 0) {
		UsuarioCrud.insertar(usuario);
	} else {
		UsuarioCrud.modificar(usuario);
	}

	// 5. Saltar a la siguiente pantalla
	response.sendRedirect("usuarios.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Mantenimiento de usuarios</title>
</head>
<body>
	<h1>Mantenimiento de usuarios</h1>

	<form action="usuario.jsp" method="post">
		<input name="id" placeholder="Id" value="<%=usuario.id()%>"> <input
			name="nombre" placeholder="Nombre" value="<%=usuario.nombre()%>"> <input
			name="email" placeholder="Email" value="<%=usuario.email()%>"> <input
			name="password" placeholder="Contraseña">

		<button>Guardar</button>
	</form>

</body>
</html>