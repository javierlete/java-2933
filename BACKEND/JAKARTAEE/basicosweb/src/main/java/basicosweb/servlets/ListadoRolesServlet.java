package basicosweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import accesodatos.RolCrud;
import dtos.Rol;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/roles")
public class ListadoRolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String rolesTexto = "";
		
		for(Rol rol: RolCrud.obtenerTodos()) {
			rolesTexto += "<li>" + rol.nombre() + "</li>";
		}
		
		out.printf("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Hola</title>
				</head>
				<body>
					<ul>
						%s
					</ul>
				</body>
				</html>
								""", rolesTexto);
	}
}
