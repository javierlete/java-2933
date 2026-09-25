package pruebaturismo.Inyeciones.Services.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.GuiaDto;

import java.util.List;

public interface GuiaService {

    GuiaDto getGuia(Long id);

    GuiaDto saveGuia(GuiaDto guia);

    void deleteGuia(Long id);

    List<GuiaDto> getAllGuias();

    GuiaDto UpdateGuia(Long id, GuiaDto guia);
}
