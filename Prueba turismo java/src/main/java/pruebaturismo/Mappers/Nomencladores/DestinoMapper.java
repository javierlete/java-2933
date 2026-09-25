package pruebaturismo.Mappers.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.DestinoDto;
import pruebaturismo.Models.Nomencladores.Destino;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DestinoMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "pais", target = "pais")
    @Mapping(source = "activo", target = "activo")
    DestinoDto DestinoToDto(Destino destino);

    @Mapping(target = "paquetes", ignore = true)
    Destino DestinoDtoToModel(DestinoDto destinoDto);

    List<DestinoDto> DestinostoDestinosDtoList(List<Destino> destinos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paquetes", ignore = true)
    void actualizarDesdeDto(DestinoDto dto, @MappingTarget Destino existente);
}
