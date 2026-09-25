package pruebaturismo.Dtos.Nomencladores;

import com.fasterxml.jackson.annotation.JsonInclude;
import pruebaturismo.Dtos.Paquetes.ComentarioDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonaDto {


    private Long id;

    private String nombre;

    private String apellido;

    private String correo;

    private String carnet;

    private List<ComentarioDto> comentarios;

    public PersonaDto(Long id, String nombre, String apellido, String correo, String carnet) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.carnet = carnet;
    }

    public PersonaDto() {
    }

}
