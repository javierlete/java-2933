package pruebaturismo.Dtos.Paquetes;

import pruebaturismo.Models.Nomencladores.Persona;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class ComentarioDto {

    private Long id;

    private String texto;

    private int puntuacion;

    private Date fecha;

    private Long persona_id;

    private Long paquete_id;

    // Se guarda la ENTIDAD Persona (no un DTO): al serializar, Jackson recorre
    // persona -> comentarios -> persona -> comentarios -> ... (JSON recursivo)
    private Persona persona;

}
