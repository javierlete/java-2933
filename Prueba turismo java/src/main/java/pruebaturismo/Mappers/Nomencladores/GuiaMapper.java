package pruebaturismo.Mappers.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.GuiaDto;
import pruebaturismo.Mappers.Paquetes.ComentarioMapper;
import pruebaturismo.Mappers.PaquetesMapperHelper;
import pruebaturismo.Models.Nomencladores.Guia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComentarioMapper.class, PaquetesMapperHelper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GuiaMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "carnet", target = "carnet")
    @Mapping(source = "idioma", target = "idioma")
    @Mapping(source = "anios_experiencia", target = "anios_experiencia")
    @Mapping(source = "comentarios", target = "comentarios")
    @Mapping(source = "paquetes", target = "paquetes_ids", qualifiedByName = "mapPaquetesToPaquetesIds")
    GuiaDto GuiaToDto(Guia guia);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "carnet", target = "carnet")
    @Mapping(source = "idioma", target = "idioma")
    @Mapping(source = "anios_experiencia", target = "anios_experiencia")
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "paquetes", ignore = true)
    Guia GuiaDtoToGuia(GuiaDto guiaDto);

    List<GuiaDto> GuiastoGuiasDtoList(List<Guia> guias);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "paquetes", ignore = true)
    void actualizarDesdeDto(GuiaDto dto, @MappingTarget Guia existente);
}
