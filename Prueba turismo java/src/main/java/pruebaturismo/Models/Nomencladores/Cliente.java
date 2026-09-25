package pruebaturismo.Models.Nomencladores;

import pruebaturismo.Models.Paquetes.Reserva;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Clientes")
public class Cliente extends Persona {
    @Column(length = 1024, name = "pais_origen")
    private String pais_origen;
    @Column(length = 1024, name = "telefono")
    private String telefono;
    @Column(name = "vip")
    private boolean vip;
    // Lado inverso de la relacion bidireccional Cliente <-> Reserva
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String carnet, String pais_origen, String telefono, boolean vip) {
        super(nombre, apellido, correo, carnet);
        this.pais_origen = pais_origen;
        this.telefono = telefono;
        this.vip = vip;
    }

}
