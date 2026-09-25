package pruebaturismo.Controllers.Nomencladores;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Nomencladores.PersonaDto;
import pruebaturismo.Inyeciones.Services.Nomencladores.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("PersonaController")
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/persona")
    @LogAction(action = "LIST", description = "Listar personas")
    public List<PersonaDto> list() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/persona/{id}")
    @LogAction(action = "GET", description = "Obtener una persona")
    public ResponseEntity<PersonaDto> view(@PathVariable Long id) {
        PersonaDto base = personaService.getPersona(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }
}
