package pruebaturismo.Inyeciones.Services.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.DestinoDto;

import java.util.List;

public interface DestinoService {

    DestinoDto getDestino(Long id);

    DestinoDto saveDestino(DestinoDto destino);

    void deleteDestino(Long id);

    List<DestinoDto> getAllDestinos();

    DestinoDto UpdateDestino(Long id, DestinoDto destino);
}
