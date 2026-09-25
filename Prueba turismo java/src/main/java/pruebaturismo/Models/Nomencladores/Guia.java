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
@Table(name = "Guias")
public class Guia extends Persona {
    @Column(length = 1024, name = "idioma")
    private String idioma;
    @Column(name = "anios_experiencia")
    private int anios_experiencia;
    // Lado inverso de la relacion bidireccional Guia <-> PaqueteTuristico
    @ManyToMany(mappedBy = "guias", fetch = FetchType.LAZY)
    private List<PaqueteTuristico> paquetes = new ArrayList<>();

    public Guia() {
    }

    public Guia(String nombre, String apellido, String correo, String carnet, String idioma, int anios_experiencia) {
        super(nombre, apellido, correo, carnet);
        this.idioma = idioma;
        this.anios_experiencia = anios_experiencia;
    }

}
