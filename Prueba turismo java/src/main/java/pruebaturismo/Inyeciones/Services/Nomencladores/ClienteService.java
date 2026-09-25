package pruebaturismo.Inyeciones.Services.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.ClienteDto;

import java.util.List;

public interface ClienteService {

    ClienteDto getCliente(Long id);

    ClienteDto saveCliente(ClienteDto cliente);

    void deleteCliente(Long id);

    List<ClienteDto> getAllClientes();

    ClienteDto UpdateCliente(Long id, ClienteDto cliente);

    List<ClienteDto> getClientes_sin_reserva_en_paquete(Long paqueteId);
}
