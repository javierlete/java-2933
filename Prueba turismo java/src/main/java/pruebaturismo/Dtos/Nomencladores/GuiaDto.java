package pruebaturismo.Dtos.Nomencladores;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GuiaDto extends PersonaDto {

    private String idioma;

    private int anios_experiencia;

    private List<Long> paquetes_ids;

    public GuiaDto() {
    }

    public GuiaDto(Long id, String nombre, String apellido, String correo, String carnet, String idioma, int anios_experiencia) {
        super(id, nombre, apellido, correo, carnet);
        this.idioma = idioma;
        this.anios_experiencia = anios_experiencia;
    }

}
