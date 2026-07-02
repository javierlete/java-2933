package basicosweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saluda")
public class SaludaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		
		out.append(String.format("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Hola</title>
				</head>
				<body>
					<h1>Hola %s, ¿qué tal estás?</h1>
				</body>
				</html>
								""", nombre));
	}
}
