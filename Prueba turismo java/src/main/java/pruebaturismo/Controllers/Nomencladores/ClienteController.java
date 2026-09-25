package pruebaturismo.Controllers.Nomencladores;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Nomencladores.ClienteDto;
import pruebaturismo.Inyeciones.Services.Nomencladores.ClienteService;
import pruebaturismo.Models.Nomencladores.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ClienteController")
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    @LogAction(action = "LIST", description = "Listar clientes")
    public List<ClienteDto> list() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/cliente/{id}")
    @LogAction(action = "GET", description = "Obtener un cliente")
    public ResponseEntity<ClienteDto> view(@PathVariable Long id) {
        ClienteDto base = clienteService.getCliente(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @GetMapping("/cliente/sin_reserva_en_paquete/{id}")
    public List<ClienteDto> sinReservaEnPaquete(@PathVariable Long id) {
        return clienteService.getClientes_sin_reserva_en_paquete(id);
    }

    @PostMapping("/cliente")
    @LogAction(action = "POST", description = "Añadir un cliente")
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto cliente) {

        ClienteDto base = clienteService.saveCliente(cliente);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }


    @PutMapping("/cliente/{id}")
    @LogAction(action = "PUT", description = "Actualizar un cliente")
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @RequestBody ClienteDto cliente) {

        ClienteDto base = clienteService.UpdateCliente(id, cliente);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/cliente/{id}")
    @LogAction(action = "DELETE", description = "Eliminar un cliente")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
