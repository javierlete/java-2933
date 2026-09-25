package pruebaturismo.Mappers.Paquetes;

import pruebaturismo.Dtos.Paquetes.ReservaDto;
import pruebaturismo.Models.Paquetes.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fecha_reserva", target = "fecha_reserva")
    @Mapping(source = "cant_personas", target = "cant_personas")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "cliente.id", target = "cliente_id")
    @Mapping(source = "paquete.id", target = "paquete_id")
    @Mapping(source = "cliente", target = "cliente")
    ReservaDto ReservaToDto(Reserva reserva);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fecha_reserva", target = "fecha_reserva")
    @Mapping(source = "cant_personas", target = "cant_personas")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "cliente_id", target = "cliente.id")
    @Mapping(source = "paquete_id", target = "paquete.id")
    Reserva ReservaDtoToModel(ReservaDto reservaDto);

    List<ReservaDto> ReservastoReservasDtoList(List<Reserva> reservas);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "paquete", ignore = true)
    void actualizarDesdeDto(ReservaDto dto, @MappingTarget Reserva existente);
}
