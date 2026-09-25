package pruebaturismo.Controllers.Paquetes;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Paquetes.ComentarioDto;
import pruebaturismo.Inyeciones.Services.Paquetes.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ComentarioController")
@RequestMapping("/api")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/comentario")
    @LogAction(action = "LIST", description = "Listar comentarios")
    public List<ComentarioDto> list() {
        return comentarioService.getAllComentarios();
    }

    @GetMapping("/comentario/{id}")
    @LogAction(action = "GET", description = "Obtener un comentario")
    public ResponseEntity<ComentarioDto> view(@PathVariable Long id) {
        ComentarioDto base = comentarioService.getComentario(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @PostMapping("/comentario")
    @LogAction(action = "POST", description = "Añadir un comentario")
    public ResponseEntity<ComentarioDto> save(@RequestBody ComentarioDto comentario) {
        ComentarioDto base = comentarioService.saveComentario(comentario);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @PutMapping("/comentario/{id}")
    @LogAction(action = "PUT", description = "Actualizar un comentario")
    public ResponseEntity<ComentarioDto> update(@PathVariable Long id, @RequestBody ComentarioDto comentario) {
        ComentarioDto base = comentarioService.UpdateComentario(id, comentario);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/comentario/{id}")
    @LogAction(action = "DELETE", description = "Eliminar un comentario")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
        return ResponseEntity.ok().build();
    }
}
