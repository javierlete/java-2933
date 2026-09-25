package pruebaturismo.Inyeciones.Repositories.Nomencladores;

import pruebaturismo.Models.Nomencladores.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
