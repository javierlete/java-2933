package pruebaturismo.Controllers.Paquetes;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Paquetes.PaqueteTuristicoDto;
import pruebaturismo.Inyeciones.Services.Paquetes.PaqueteTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("PaqueteTuristicoController")
@RequestMapping("/api")
public class PaqueteTuristicoController {
    @Autowired
    private PaqueteTuristicoService paqueteService;

    @GetMapping("/paquete")
    @LogAction(action = "LIST", description = "Listar paquetes turisticos")
    public List<PaqueteTuristicoDto> list() {
        return paqueteService.getAllPaquetes();
    }

    @GetMapping("/paquete/{id}")
    @LogAction(action = "GET", description = "Obtener un paquete turistico")
    public ResponseEntity<PaqueteTuristicoDto> view(@PathVariable Long id) {
        PaqueteTuristicoDto base = paqueteService.getPaquete(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @PostMapping("/paquete")
    @LogAction(action = "POST", description = "Añadir un paquete turistico")
    public ResponseEntity<PaqueteTuristicoDto> save(@RequestBody PaqueteTuristicoDto paquete) {
        PaqueteTuristicoDto base = paqueteService.savePaquete(paquete);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @PutMapping("/paquete/{id}")
    @LogAction(action = "PUT", description = "Actualizar un paquete turistico")
    public ResponseEntity<PaqueteTuristicoDto> update(@PathVariable Long id, @RequestBody PaqueteTuristicoDto paquete) {
        PaqueteTuristicoDto base = paqueteService.UpdatePaquete(id, paquete);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/paquete/{id}")
    @LogAction(action = "DELETE", description = "Eliminar un paquete turistico")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paqueteService.deletePaquete(id);
        return ResponseEntity.ok().build();
    }
}
