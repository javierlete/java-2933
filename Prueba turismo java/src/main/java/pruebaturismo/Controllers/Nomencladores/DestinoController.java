package pruebaturismo.Controllers.Nomencladores;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Nomencladores.DestinoDto;
import pruebaturismo.Inyeciones.Services.Nomencladores.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("DestinoController")
@RequestMapping("/api")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;

    @GetMapping("/destino")
    @LogAction(action = "LIST", description = "Listar destinos")
    public List<DestinoDto> list() {
        return destinoService.getAllDestinos();
    }

    @GetMapping("/destino/{id}")
    @LogAction(action = "GET", description = "Obtener un destino")
    public ResponseEntity<DestinoDto> view(@PathVariable Long id) {
        DestinoDto base = destinoService.getDestino(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @PostMapping("/destino")
    @LogAction(action = "POST", description = "Añadir un destino")
    public ResponseEntity<DestinoDto> save(@RequestBody DestinoDto destino) {
        DestinoDto base = destinoService.saveDestino(destino);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @PutMapping("/destino/{id}")
    @LogAction(action = "PUT", description = "Actualizar un destino")
    public ResponseEntity<DestinoDto> update(@PathVariable Long id, @RequestBody DestinoDto destino) {
        DestinoDto base = destinoService.UpdateDestino(id, destino);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/destino/{id}")
    @LogAction(action = "DELETE", description = "Eliminar un destino")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        destinoService.deleteDestino(id);
        return ResponseEntity.ok().build();
    }
}
