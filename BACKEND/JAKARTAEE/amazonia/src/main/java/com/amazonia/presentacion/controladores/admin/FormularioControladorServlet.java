package com.amazonia.presentacion.controladores.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import com.amazonia.dtos.Producto;
import com.amazonia.logicanegocio.AdministradorNegocio;
import com.amazonia.logicanegocio.AnonimoNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/admin/formulario")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB (Guarda en disco si supera este tamaño)
		maxFileSize = 1024 * 1024 * 10, // 10MB (Tamaño máximo de un archivo)
		maxRequestSize = 1024 * 1024 * 50 // 50MB (Tamaño máximo de la petición completa)
)
public class FormularioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recibir información de la petición
		String sId = request.getParameter("id");

		// 2. Convertir los datos
		if (sId != null) {
			Long id = Long.parseLong(sId);

			// 3. Crear un objeto con ellos
			// 4. Llamar a la lógica de negocio
			Producto producto = AnonimoNegocio.verDetalleProducto(id);

			// 5. Empaquetar la información para la siguiente vista
			request.setAttribute("producto", producto);
		}

		// 6. Saltar a la siguiente vista
		request.getRequestDispatcher("/admin/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Define la ruta donde deseas guardar los ficheros
        String uploadPath = getServletContext().getRealPath("") + File.separator + "fotos";
        File uploadDir = new File(uploadPath);
        
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        // 1. Recibir información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");

		// Obtiene el fichero usando el atributo "name" del input del HTML
		Part filePart = request.getPart("imagen");
		
		// 2. Convertir los datos
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal precio = sPrecio.isBlank() ? null : new BigDecimal(sPrecio);
		

		// 3. Crear un objeto con ellos
		Producto producto = new Producto(id, nombre, descripcion, precio);

		// 4. Llamar a la lógica de negocio
		HashMap<String, String> errores = AdministradorNegocio.validarProducto(producto);

		if (errores.size() > 0) {
			// 5. Empaquetar la información para la siguiente vista
			request.setAttribute("errores", errores);
			request.setAttribute("producto", producto);

			// 6. Saltar a la siguiente vista
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
			return;
		}

		if (id == null) {
			AdministradorNegocio.altaProducto(producto);
		} else {
			AdministradorNegocio.modificarProducto(producto);
		}

		if (filePart != null && filePart.getSize() > 0) {
			// Extrae el nombre original del archivo enviado
			// String fileName = filePart.getSubmittedFileName();
			
			// Construye la ruta final y guarda el fichero en el servidor
			String fullPath = uploadPath + File.separator + producto.id() + ".jpg";
			filePart.write(fullPath);
		}
		
		// 5. Empaquetar la información para la siguiente vista
		// 6. Saltar a la siguiente vista
		response.sendRedirect("listado");
	}

}
