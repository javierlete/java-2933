package pruebaturismo.Controllers.Paquetes;

import pruebaturismo.Annotations.LogAction;
import pruebaturismo.Dtos.Paquetes.ReservaDto;
import pruebaturismo.Inyeciones.Services.Paquetes.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ReservaController")
@RequestMapping("/api")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reserva")
    @LogAction(action = "LIST", description = "Listar reservas")
    public List<ReservaDto> list() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/reserva/{id}")
    @LogAction(action = "GET", description = "Obtener una reserva")
    public ResponseEntity<ReservaDto> view(@PathVariable Long id) {
        ReservaDto base = reservaService.getReserva(id);
        if (base == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(base);
    }

    @PostMapping("/reserva")
    @LogAction(action = "POST", description = "Añadir una reserva")
    public ResponseEntity<ReservaDto> save(@RequestBody ReservaDto reserva) {
        ReservaDto base = reservaService.saveReserva(reserva);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @PutMapping("/reserva/{id}")
    @LogAction(action = "PUT", description = "Actualizar una reserva")
    public ResponseEntity<ReservaDto> update(@PathVariable Long id, @RequestBody ReservaDto reserva) {
        ReservaDto base = reservaService.UpdateReserva(id, reserva);
        if (base == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(base);
    }

    @DeleteMapping("/reserva/{id}")
    @LogAction(action = "DELETE", description = "Eliminar una reserva")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok().build();
    }
}
