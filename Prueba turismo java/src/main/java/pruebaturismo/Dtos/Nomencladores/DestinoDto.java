package pruebaturismo.Dtos.Nomencladores;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DestinoDto {

    private Long id;

    private String nombre;

    private String pais;

    private boolean activo;

//  private List<PaqueteTuristico> paquetes = new ArrayList<>();

    public DestinoDto() {

    }

    public DestinoDto(Long id, String nombre, String pais, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.activo = activo;
    }

}
