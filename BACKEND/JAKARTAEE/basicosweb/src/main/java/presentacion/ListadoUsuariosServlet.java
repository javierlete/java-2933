package presentacion;

import java.io.IOException;
import java.io.PrintWriter;

import accesodatos.UsuarioCrud;
import dtos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class ListadoUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String borrar = request.getParameter("borrar");
		
		System.out.println(borrar);
		
		if(borrar != null) {
			Long id = Long.parseLong(borrar);
			UsuarioCrud.borrar(id);
		}
		
		String usuariosTexto = "";
		
		for(Usuario usuario: UsuarioCrud.obtenerTodos()) {
			usuariosTexto += String.format("""
					<tr>
						<th>%s</th>
						<td>%s</td>
						<td>%s</td>
						<td>%s</td>
						<td>
							<a href="usuario?id=%s">Editar</a>
							<a href="usuarios?borrar=%s">Borrar</a>
						</td>
					</tr>
					""", 
					usuario.id(),
					usuario.nombre(),
					usuario.email(),
					usuario.rolNombre(),
					usuario.id(),
					usuario.id()
					);
		}
		
		out.printf("""
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
							%s
						</tbody>
						
						<tfoot>
							<tr>
								<td colspan="4"></td>
								<td>
									<a href="usuario">Añadir</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</body>
				</html>
								""", usuariosTexto);
	}
}
