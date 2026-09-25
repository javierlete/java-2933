package pruebaturismo.Models.Paquetes;

import pruebaturismo.Enums.EstadoReserva;
import pruebaturismo.Models.Nomencladores.Cliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

    @Column(name = "cant_personas")
    private int cant_personas;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoReserva estado;

    // Lado duenno de la relacion bidireccional Cliente <-> Reserva
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Lado duenno de la relacion bidireccional PaqueteTuristico <-> Reserva
    @ManyToOne
    @JoinColumn(name = "paquete_id", nullable = false)
    private PaqueteTuristico paquete;
}
