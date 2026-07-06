package presentacion.controladores;

import java.io.IOException;

import accesodatos.UsuarioCrud;
import dtos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/usuario")
public class UsuarioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario(0L, "", "", "", 0L, "");

		// 1. Recibir información de la petición
		String strId = request.getParameter("id");

		if (strId != null) {
			// 2. Convertir los datos
			Long id = Long.parseLong(strId);
			
			// 4. Procesar los datos
			usuario = UsuarioCrud.obtenerPorId(id);
		}

		// 5. Empaquetar la información para la siguiente vista
		request.setAttribute("usuario", usuario);

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String strId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. Convertir los datos
		Long id = Long.parseLong(strId);
		
		// 3. Crear un objeto con ellos
		Usuario usuario = new Usuario(id, nombre, email, password, 2L, null);

		// 4. Procesar los datos
		if(usuario.id() == 0) {
			UsuarioCrud.insertar(usuario);
		} else {
			UsuarioCrud.modificar(usuario);
		}

		// 6. Saltar a la siguiente vista
		response.sendRedirect("usuarios");
	}
}
