package pruebaturismo.ServicesImp.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.PersonaDto;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.PersonaRepository;
import pruebaturismo.Inyeciones.Services.Nomencladores.PersonaService;
import pruebaturismo.Mappers.Nomencladores.PersonaMapper;
import pruebaturismo.Models.Nomencladores.Persona;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PersonaServiceImp")
public class PersonaServiceImp implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Autowired
    public PersonaServiceImp(PersonaRepository personaRepository, PersonaMapper personaMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    // Obtener por ID con relaciones
    public PersonaDto getPersona(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada"));
        return personaMapper.PersonatoDto(persona);
    }

    // Listar todas las personas con relaciones
    public List<PersonaDto> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.PersonastoPersonasDtoList(personas);
    }
}
