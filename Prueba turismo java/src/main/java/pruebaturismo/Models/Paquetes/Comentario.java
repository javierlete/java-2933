package pruebaturismo.Models.Paquetes;

import pruebaturismo.Models.Nomencladores.Persona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048, name = "texto")
    private String texto;

    @Column(name = "puntuacion")
    private int puntuacion;

    @Column(name = "fecha")
    private Date fecha;

    // Lado duenno de la relacion bidireccional Persona <-> Comentario
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    // Lado duenno de la relacion bidireccional PaqueteTuristico <-> Comentario
    @ManyToOne
    @JoinColumn(name = "paquete_id", nullable = false)
    private PaqueteTuristico paquete;
}
