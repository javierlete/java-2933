package pruebaturismo.Inyeciones.Services.Paquetes;

import pruebaturismo.Dtos.Paquetes.PaqueteTuristicoDto;

import java.util.List;

public interface PaqueteTuristicoService {

    PaqueteTuristicoDto getPaquete(Long id);

    PaqueteTuristicoDto savePaquete(PaqueteTuristicoDto paquete);

    void deletePaquete(Long id);

    List<PaqueteTuristicoDto> getAllPaquetes();

    PaqueteTuristicoDto UpdatePaquete(Long id, PaqueteTuristicoDto paquete);
}
