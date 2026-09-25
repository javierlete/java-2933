package pruebaturismo.Dtos.Nomencladores;

import com.fasterxml.jackson.annotation.JsonInclude;
import pruebaturismo.Dtos.Paquetes.ReservaDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ClienteDto extends PersonaDto {

    private String pais_origen;

    private String telefono;

    private boolean vip;

    private List<ReservaDto> reservas;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nombre, String apellido, String correo, String carnet, String pais_origen, String telefono, boolean vip) {
        super(id, nombre, apellido, correo, carnet);
        this.pais_origen = pais_origen;
        this.telefono = telefono;
        this.vip = vip;
    }

}
