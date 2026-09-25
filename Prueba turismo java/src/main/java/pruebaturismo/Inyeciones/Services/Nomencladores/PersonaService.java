package pruebaturismo.Inyeciones.Services.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.PersonaDto;

import java.util.List;

public interface PersonaService {

    PersonaDto getPersona(Long id);

    List<PersonaDto> getAllPersonas();
}
