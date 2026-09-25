package pruebaturismo.Dtos.Paquetes;

import pruebaturismo.Enums.EstadoReserva;
import pruebaturismo.Models.Nomencladores.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class ReservaDto {

    private Long id;

    private Date fecha_reserva;

    private int cant_personas;

    private EstadoReserva estado;

    private Long cliente_id;

    private Long paquete_id;

    // Se guarda la ENTIDAD Cliente (no un DTO): al serializar, Jackson recorre
    // cliente -> reservas -> cliente -> reservas -> ... (JSON recursivo)
    private Cliente cliente;

}
