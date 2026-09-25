package pruebaturismo.ServicesImp.Paquetes;

import pruebaturismo.Dtos.Paquetes.ComentarioDto;
import pruebaturismo.Inyeciones.Repositories.Paquetes.ComentarioRepository;
import pruebaturismo.Inyeciones.Services.Paquetes.ComentarioService;
import pruebaturismo.Mappers.Paquetes.ComentarioMapper;
import pruebaturismo.Models.Paquetes.Comentario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ComentarioServiceImp")
public class ComentarioServiceImp implements ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ComentarioMapper comentarioMapper;

    @Autowired
    public ComentarioServiceImp(ComentarioRepository comentarioRepository, ComentarioMapper comentarioMapper) {
        this.comentarioRepository = comentarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    public List<ComentarioDto> getAllComentarios() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return comentarioMapper.ComentariostoComentariosDtoList(comentarios);
    }

    public ComentarioDto getComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentario no encontrado"));
        return comentarioMapper.ComentarioToDto(comentario);
    }

    public ComentarioDto saveComentario(ComentarioDto dto) {
        Comentario comentario = comentarioMapper.ComentarioDtoToModel(dto);
        Comentario guardado = comentarioRepository.save(comentario);
        return comentarioMapper.ComentarioToDto(guardado);
    }

    public ComentarioDto UpdateComentario(Long id, ComentarioDto dto) {
        Comentario existente = comentarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentario no encontrado"));
        comentarioMapper.actualizarDesdeDto(dto, existente);
        Comentario actualizado = comentarioRepository.save(existente);
        return comentarioMapper.ComentarioToDto(actualizado);
    }

    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
