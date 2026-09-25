package pruebaturismo.ServicesImp.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.ClienteDto;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.ClienteRepository;
import pruebaturismo.Inyeciones.Services.Nomencladores.ClienteService;
import pruebaturismo.Mappers.Nomencladores.ClienteMapper;
import pruebaturismo.Models.Nomencladores.Cliente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClienteServiceImp")
public class ClienteServiceImp implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImp(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    // Listar todos los clientes con relaciones
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.ClientestoClientesDtoList(clientes);
    }

    // Obtener por ID con relaciones
    public ClienteDto getCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        return clienteMapper.ClienteToDto(cliente);
    }

    // Crear
    public ClienteDto saveCliente(ClienteDto dto) {
        Cliente cliente = clienteMapper.ClienteDtoToCliente(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return clienteMapper.ClienteToDto(guardado);
    }

    // Actualizar
    public ClienteDto UpdateCliente(Long id, ClienteDto dto) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        clienteMapper.actualizarDesdeDto(dto, existente);
        Cliente actualizado = clienteRepository.save(existente);
        return clienteMapper.ClienteToDto(actualizado);
    }

    @Override
    public List<ClienteDto> getClientes_sin_reserva_en_paquete(Long paqueteId) {
        List<Cliente> clientes = clienteRepository.findClientesSinReservaEnPaquete(paqueteId);
        return clienteMapper.ClientestoClientesDtoList(clientes);
    }

    // Eliminar
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
