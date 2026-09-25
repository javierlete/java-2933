package pruebaturismo.Mappers.Paquetes;

import pruebaturismo.Dtos.Paquetes.PaqueteTuristicoDto;
import pruebaturismo.Mappers.GuiasMapperHelper;
import pruebaturismo.Mappers.Nomencladores.DestinoMapper;
import pruebaturismo.Mappers.Nomencladores.GuiaMapper;
import pruebaturismo.Models.Paquetes.PaqueteTuristico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                DestinoMapper.class,
                GuiaMapper.class,
                ComentarioMapper.class,
                ReservaMapper.class,
                GuiasMapperHelper.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PaqueteTuristicoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "duracion_dias", target = "duracion_dias")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(source = "destino.id", target = "destino_id")
    @Mapping(source = "destino", target = "destino")
    @Mapping(source = "guias", target = "guias")
    @Mapping(source = "guias", target = "guias_ids", qualifiedByName = "mapGuiasToGuiasIds")
    @Mapping(source = "comentarios", target = "comentarios")
    @Mapping(source = "reservas", target = "reservas")
    PaqueteTuristicoDto PaquetetoPaqueteDto(PaqueteTuristico paquete);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "duracion_dias", target = "duracion_dias")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(target = "destino", ignore = true)
    @Mapping(source = "guias_ids", target = "guias", qualifiedByName = "mapGuiasIdsToGuias")
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    PaqueteTuristico paquetefromDto(PaqueteTuristicoDto paqueteDto);

    List<PaqueteTuristicoDto> PaquetestoPaquetesDtoList(List<PaqueteTuristico> paquetes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "destino", ignore = true)
    @Mapping(source = "guias_ids", target = "guias", qualifiedByName = "mapGuiasIdsToGuias")
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    void actualizarDesdeDto(PaqueteTuristicoDto dto, @MappingTarget PaqueteTuristico existente);
}
