package pruebaturismo.Controllers.Enums;

import cu.edu.cujae.pruebaturismo.Enums.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaturismo.Enums.EstadoReserva;
import pruebaturismo.Enums.TipoPaquete;

@RestController
@RequestMapping("/api/enums")
public class EnumsController {

    @GetMapping("/tipo_paquete")
    public ResponseEntity<TipoPaquete[]> getTiposPaquete() {
        return ResponseEntity.ok(TipoPaquete.values());
    }

    @GetMapping("/estado_reserva")
    public ResponseEntity<EstadoReserva[]> getEstadosReserva() {
        return ResponseEntity.ok(EstadoReserva.values());
    }
}
