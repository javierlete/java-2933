package pruebaturismo.Models.Paquetes;

import pruebaturismo.Enums.TipoPaquete;
import pruebaturismo.Models.Nomencladores.Destino;
import pruebaturismo.Models.Nomencladores.Guia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Paquete_turistico")
public class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 1024, name = "nombre")
    private String nombre;
    @Column(length = 2048, name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private double precio;
    @Column(name = "duracion_dias")
    private int duracion_dias;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPaquete tipo;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "destino_id")
    private Destino destino;
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "Paquete_Guias", joinColumns = @JoinColumn(name = "paquete_id"), inverseJoinColumns = @JoinColumn(name = "guia_id"))
    private List<Guia> guias = new ArrayList<>();
    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();
    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comentario> comentarios = new ArrayList<>();

    public PaqueteTuristico() {

    }

    public PaqueteTuristico(String nombre, String descripcion, double precio, int duracion_dias, TipoPaquete tipo, Destino destino) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion_dias = duracion_dias;
        this.tipo = tipo;
        this.destino = destino;
    }
}
