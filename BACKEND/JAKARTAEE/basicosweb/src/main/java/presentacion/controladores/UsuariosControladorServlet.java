package presentacion.controladores;

import java.io.IOException;

import accesodatos.UsuarioCrud;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/usuarios")
public class UsuariosControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String borrar = request.getParameter("borrar");

		if (borrar != null) {
			// 2. Convertir los datos
			Long id = Long.parseLong(borrar);

			// 4. Procesar los datos
			UsuarioCrud.borrar(id);
		}

		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("usuarios",  UsuarioCrud.obtenerTodos());

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/usuarios.jsp").forward(request, response);
	}
}
