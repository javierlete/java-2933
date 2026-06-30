package presentacion;

import static bibliotecas.Consola.pedirInt;
import static bibliotecas.Consola.pl;

import java.util.ArrayList;

import accesodatos.UsuarioCrud;
import dtos.Usuario;

public class UsuariosConsolaAplicacion {
	private static final int SALIR = 0;

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("""
				
				
				MENU
				====

				1. Listado usuarios
				2. Buscar por email

				3. Alta
				4. Modificación
				5. Baja

				0. Salir

				""");
	}

	private static int pedirOpcion() {
		return pedirInt("Dime la opción");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1 -> listado();
		case 2 -> buscarPorEmail();
		case 3 -> alta();
		case 4 -> modificacion();
		case 5 -> baja();
		case SALIR -> pl("Gracias por usar esta aplicación");
		}
	}

	private static void listado() {
		ArrayList<Usuario> usuarios = UsuarioCrud.obtenerTodos();
		
		for(Usuario usuario: usuarios) {
			pl(usuario);
		}
	}

	private static void buscarPorEmail() {
		// TODO Auto-generated method stub
	}

	private static void alta() {
		// TODO Auto-generated method stub
	}

	private static void modificacion() {
		// TODO Auto-generated method stub
	}

	private static void baja() {
		// TODO Auto-generated method stub
	}
}
