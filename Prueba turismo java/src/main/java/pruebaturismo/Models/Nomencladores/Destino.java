package pruebaturismo.Models.Nomencladores;

import pruebaturismo.Models.Paquetes.PaqueteTuristico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Destino")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024, name = "nombre")
    private String nombre;
    @Column(length = 1024, name = "pais")
    private String pais;
    @Column(name = "activo")
    private boolean activo;
    // Lado inverso de la relacion bidireccional Destino <-> PaqueteTuristico
    @OneToMany(mappedBy = "destino", fetch = FetchType.LAZY)
    private List<PaqueteTuristico> paquetes = new ArrayList<>();

    public Destino() {

    }

    public Destino(String nombre, String pais, boolean activo) {
        this.nombre = nombre;
        this.pais = pais;
        this.activo = activo;
    }
}
