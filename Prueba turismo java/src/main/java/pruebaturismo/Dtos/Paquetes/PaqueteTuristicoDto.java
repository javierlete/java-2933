package pruebaturismo.Dtos.Paquetes;

import com.fasterxml.jackson.annotation.JsonInclude;
import pruebaturismo.Dtos.Nomencladores.DestinoDto;
import pruebaturismo.Dtos.Nomencladores.GuiaDto;
import pruebaturismo.Enums.TipoPaquete;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PaqueteTuristicoDto {


    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int duracion_dias;

    private TipoPaquete tipo;

    private Long destino_id;

    private DestinoDto destino;

    private List<Long> guias_ids;

    private List<GuiaDto> guias;

    private List<ComentarioDto> comentarios;

    private List<ReservaDto> reservas;


    public PaqueteTuristicoDto() {

    }

}
