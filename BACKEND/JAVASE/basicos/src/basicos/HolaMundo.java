package basicos;

/**
 * Ejemplo de Java básico
 */
public class HolaMundo {
	/**
	 * Método de entrada de la aplicación
	 * 
	 * @param args argumentos recibidos por consola
	 */
	public static void main(String[] args) {
		/*
		 * Vamos a demostrar aquí las funcionalidades básicas del lenguaje
		 */

		System.out.println("Hola a todos"); // Muestra un mensaje por pantalla

		double d1 = 0.1;
		double d2 = 0.2;

		double suma = d1 + d2;

		System.out.println(suma);

		@SuppressWarnings("unused")
		long l = 11231231231L;

		char c = 'A';

		int i = c;

		System.out.println(i);

		for (int codigo = 32; codigo <= 127; codigo++) {
			char letra = (char) codigo;
			System.out.println(letra + "=" + codigo);
		}
		
		String nombre = "Javier";
		
		System.out.println("El nombre es " + nombre.toUpperCase());
	}
}
