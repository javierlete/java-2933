package basicos;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		int tamanyo = 2;
		int[] arr = new int[tamanyo];

//		arr[0] = 5;
		arr[1] = 6;
//		arr[2] = 7; // Excepción

		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);

		System.out.println(arr[1]);

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%s]: %s\n", i, arr[i]);
		}

		for (int dato : arr) {
			System.out.println(dato);
		}

		String[][] tablero = new String[8][8];

		tablero[0][0] = "T";
		tablero[1][0] = "C";
		tablero[0][1] = "P";

		tablero[7][7] = "t";

		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				String casilla = tablero[y][x];
				
				if (casilla != null) {
					System.out.print(casilla + " ");
				} else {
					System.out.print(". ");
				}
			}

			System.out.println();
		}
	}
}
