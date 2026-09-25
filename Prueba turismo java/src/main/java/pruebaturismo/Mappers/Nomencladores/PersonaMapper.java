package pruebaturismo.Mappers.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.PersonaDto;
import pruebaturismo.Mappers.Paquetes.ComentarioMapper;
import pruebaturismo.Models.Nomencladores.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComentarioMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonaMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "carnet", target = "carnet")
    @Mapping(source = "comentarios", target = "comentarios")
    PersonaDto PersonatoDto(Persona persona);

    @Mapping(target = "comentarios", ignore = true)
    Persona PersonaDtotoModel(PersonaDto personaDto);

    List<PersonaDto> PersonastoPersonasDtoList(List<Persona> personas);
}
