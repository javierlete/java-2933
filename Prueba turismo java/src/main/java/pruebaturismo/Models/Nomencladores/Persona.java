package pruebaturismo.Models.Nomencladores;

import pruebaturismo.Models.Paquetes.Comentario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 1024, name = "nombre")
    private String nombre;
    @Column(length = 1024, name = "apellido")
    private String apellido;
    @Column(length = 1024, name = "correo")
    private String correo;
    @Column(length = 1024, name = "carnet")
    private String carnet;
    // Lado inverso de la relacion bidireccional Persona <-> Comentario
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comentario> comentarios = new ArrayList<>();


    public Persona(String nombre, String apellido, String correo, String carnet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.carnet = carnet;
    }

    public Persona() {
    }

}
