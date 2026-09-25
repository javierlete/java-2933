package pruebaturismo.Mappers.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.ClienteDto;
import pruebaturismo.Mappers.Paquetes.ComentarioMapper;
import pruebaturismo.Mappers.Paquetes.ReservaMapper;
import pruebaturismo.Models.Nomencladores.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComentarioMapper.class, ReservaMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "carnet", target = "carnet")
    @Mapping(source = "pais_origen", target = "pais_origen")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "vip", target = "vip")
    @Mapping(source = "comentarios", target = "comentarios")
    @Mapping(source = "reservas", target = "reservas")
    ClienteDto ClienteToDto(Cliente cliente);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "carnet", target = "carnet")
    @Mapping(source = "pais_origen", target = "pais_origen")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "vip", target = "vip")
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Cliente ClienteDtoToCliente(ClienteDto clienteDto);

    List<ClienteDto> ClientestoClientesDtoList(List<Cliente> clientes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comentarios", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    void actualizarDesdeDto(ClienteDto dto, @MappingTarget Cliente existente);
}
