package pruebaturismo.Inyeciones.Services.Paquetes;

import pruebaturismo.Dtos.Paquetes.ComentarioDto;

import java.util.List;

public interface ComentarioService {

    ComentarioDto getComentario(Long id);

    ComentarioDto saveComentario(ComentarioDto comentario);

    void deleteComentario(Long id);

    List<ComentarioDto> getAllComentarios();

    ComentarioDto UpdateComentario(Long id, ComentarioDto comentario);
}
