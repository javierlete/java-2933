package pruebaturismo.Inyeciones.Repositories.Paquetes;

import pruebaturismo.Models.Paquetes.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
