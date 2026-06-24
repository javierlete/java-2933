package productosconsola;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductosConsolaAplicacion {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:productosconsola.db");
				Scanner sc = new Scanner(System.in)) {

			int opcion;

			do {
				System.out.println("""
						MENU
						====

						1. Listado
						2. Buscar por id

						3. Insertar
						4. Modificar
						5. Borrar

						0. Salir

						""");

				System.out.print("Selecciona una opción: ");
				opcion = Integer.parseInt(sc.nextLine());

				System.out.println();

				switch (opcion) {
				case 1:
					System.out.println("LISTADO\n");

					System.out.printf("%2s %-20s %12s\n", "Id", "Nombre", "Precio");
					System.out.printf("%2s %-20s %12s\n", "--", "------", "------");

					try (PreparedStatement pst = con.prepareStatement("SELECT * FROM productos");
							ResultSet rs = pst.executeQuery()) {

						while (rs.next()) {
							System.out.printf("%2d %-20s %,10.2f €\n", rs.getLong("id"), rs.getString("nombre"),
									rs.getBigDecimal("precio"));
						}
					} catch (SQLException e) {
						System.out.println("Error al hacer el listado");
					}

					break;

				case 2: {
					System.out.println("BUSCAR POR ID\n");

					System.out.print("Dime el id: ");
					Long id = Long.parseLong(sc.nextLine());

					System.out.println();

					try (PreparedStatement pst = con.prepareStatement("SELECT * FROM productos WHERE id=?")) {

						pst.setLong(1, id);

						try (ResultSet rs = pst.executeQuery()) {
							if (rs.next()) {
								System.out.printf("%6s: %s\n", "Id", rs.getLong("id"));
								System.out.printf("%6s: %s\n", "Nombre", rs.getString("nombre"));
								System.out.printf("%6s: %s\n", "Precio", rs.getBigDecimal("precio"));
							} else {
								System.out.println("No se ha encontrado el id " + id);
							}
						}
					} catch (SQLException e) {
						System.out.println("Error al buscar el producto por id");
					}

					break;
				}
				
				case 3: {
					System.out.println("INSERTAR\n");

					System.out.print("Nombre: ");
					String nombre = sc.nextLine();

					System.out.print("Precio: ");
					BigDecimal precio = new BigDecimal(sc.nextLine());

					try (PreparedStatement pst = con
							.prepareStatement("INSERT INTO productos (nombre, precio) VALUES (?, ?)")) {

						pst.setString(1, nombre);
						pst.setBigDecimal(2, precio);

						int numeroRegistrosModificados = pst.executeUpdate();

						if (numeroRegistrosModificados == 1) {
							System.out.println("Inserción correcta");
						} else {
							System.out.println("Se han modificado " + numeroRegistrosModificados);
						}
					} catch (SQLException e) {
						System.out.println("Error al hacer la inserción");
					}

					break;
				}
				
				case 4: {
					System.out.println("MODIFICAR\n");

					System.out.print("Id: ");
					Long id = Long.parseLong(sc.nextLine());

					System.out.print("Nombre: ");
					String nombre = sc.nextLine();

					System.out.print("Precio: ");
					BigDecimal precio = new BigDecimal(sc.nextLine());

					try (PreparedStatement pst = con
							.prepareStatement("UPDATE productos SET nombre=?, precio=? WHERE id=?")) {

						pst.setString(1, nombre);
						pst.setBigDecimal(2, precio);
						pst.setLong(3, id);

						int numeroRegistrosModificados = pst.executeUpdate();

						if (numeroRegistrosModificados == 1) {
							System.out.println("Modificación correcta");
						} else {
							System.out.println("Se han modificado " + numeroRegistrosModificados);
						}
					} catch (SQLException e) {
						System.out.println("Error al hacer la modificación");
					}

					break;
				}
				
				case 5: {
					System.out.println("BORRAR\n");

					System.out.print("Id: ");
					Long id = Long.parseLong(sc.nextLine());

					try (PreparedStatement pst = con.prepareStatement("DELETE FROM productos WHERE id=?")) {

						pst.setLong(1, id);

						int numeroRegistrosModificados = pst.executeUpdate();

						if (numeroRegistrosModificados == 1) {
							System.out.println("Borrado correcto");
						} else {
							System.out.println("Se han modificado " + numeroRegistrosModificados);
						}
					} catch (SQLException e) {
						System.out.println("Error al ejecutar el borrado");
					}

					break;
				}
				
				case 0:
					System.out.println("Gracias por usar el programa");
					break;
					
				default:
					System.out.println("Opción no reconocida");
				}

				System.out.println();
			} while (opcion != 0);

		} catch (NumberFormatException | SQLException e) {
			System.out.println("Error no controlado en la aplicación");
			System.out.println(e.getMessage());
		}
	}
}
