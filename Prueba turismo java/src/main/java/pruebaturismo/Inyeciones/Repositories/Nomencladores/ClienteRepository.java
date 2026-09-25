package pruebaturismo.Inyeciones.Repositories.Nomencladores;

import pruebaturismo.Models.Nomencladores.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c NOT IN " +
            "(SELECT r.cliente FROM Reserva r WHERE r.paquete.id = :paqueteId)")
    List<Cliente> findClientesSinReservaEnPaquete(@Param("paqueteId") Long paqueteId);
}
