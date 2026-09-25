package pruebaturismo.Mappers.Paquetes;

import pruebaturismo.Dtos.Paquetes.ComentarioDto;
import pruebaturismo.Models.Paquetes.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComentarioMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "texto", target = "texto")
    @Mapping(source = "puntuacion", target = "puntuacion")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "persona.id", target = "persona_id")
    @Mapping(source = "paquete.id", target = "paquete_id")
    @Mapping(source = "persona", target = "persona")
    ComentarioDto ComentarioToDto(Comentario comentario);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "texto", target = "texto")
    @Mapping(source = "puntuacion", target = "puntuacion")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "persona_id", target = "persona.id")
    @Mapping(source = "paquete_id", target = "paquete.id")
    Comentario ComentarioDtoToModel(ComentarioDto comentarioDto);

    List<ComentarioDto> ComentariostoComentariosDtoList(List<Comentario> comentarios);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "paquete", ignore = true)
    void actualizarDesdeDto(ComentarioDto dto, @MappingTarget Comentario existente);
}
