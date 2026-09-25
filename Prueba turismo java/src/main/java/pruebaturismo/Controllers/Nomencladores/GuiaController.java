package pruebaturismo.Controllers.Nomencladores;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Nomencladores.GuiaDto;
import pruebaturismo.Inyeciones.Services.Nomencladores.GuiaService;
import pruebaturismo.Models.Nomencladores.Guia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("GuiaController")
@RequestMapping("/api")
public class GuiaController {
    @Autowired
    private GuiaService guiaService;

    @GetMapping("/guia")
    @LogAction(action = "LIST", description = "Listar guias")
    public List<GuiaDto> list() {
        return guiaService.getAllGuias();
    }

    @GetMapping("/guia/{id}")
    @LogAction(action = "GET", description = "Obtener un guia")
    public ResponseEntity<GuiaDto> view(@PathVariable Long id) {
        GuiaDto base = guiaService.getGuia(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @PostMapping("/guia")
    @LogAction(action = "POST", description = "Añadir un guia")
    public ResponseEntity<GuiaDto> save(@RequestBody GuiaDto guia) {
        GuiaDto base = guiaService.saveGuia(guia);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @PutMapping("/guia/{id}")
    @LogAction(action = "PUT", description = "Actualizar un guia")
    public ResponseEntity<GuiaDto> update(@PathVariable Long id, @RequestBody GuiaDto guia) {
        GuiaDto base = guiaService.UpdateGuia(id, guia);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/guia/{id}")
    @LogAction(action = "DELETE", description = "Eliminar un guia")
    public ResponseEntity<Guia> delete(@PathVariable Long id) {
        guiaService.deleteGuia(id);
        return ResponseEntity.ok().build();
    }
}
