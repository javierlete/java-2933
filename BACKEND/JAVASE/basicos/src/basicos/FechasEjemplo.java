package basicos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FechasEjemplo {
	public static void main(String[] args) {
		LocalDateTime ahora = LocalDateTime.now();

		System.out.println(ahora);

		LocalDate fechaNacimiento = LocalDate.of(2000, 1, 1);

		System.out.println(fechaNacimiento);

		LocalDate hoy = LocalDate.now();

		int anyos = Period.between(fechaNacimiento, hoy).getYears();

		System.out.println(anyos);

		LocalDate diaSuscripcion = LocalDate.of(2026, 1, 31);

		LocalDate diaSiguienteCuota;

		for (int mes = 1; mes <= 12; mes++) {
			diaSiguienteCuota = diaSuscripcion.plusMonths(mes - 1);
			System.out.println(diaSiguienteCuota);
		}
		
		DateTimeFormatter fechaEspanyola = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String fechaTexto = "19/06/2026";
		
		LocalDate localDate = LocalDate.parse(fechaTexto, fechaEspanyola);
		
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate.getDayOfMonth());
		System.out.println(localDate.getMonth());
		System.out.println(localDate.getYear());
		
		System.out.println(localDate.format(fechaEspanyola));
	}
}
