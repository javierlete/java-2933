package pruebaturismo.ServicesImp.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.DestinoDto;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.DestinoRepository;
import pruebaturismo.Inyeciones.Services.Nomencladores.DestinoService;
import pruebaturismo.Mappers.Nomencladores.DestinoMapper;
import pruebaturismo.Models.Nomencladores.Destino;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DestinoServiceImp")
public class DestinoServiceImp implements DestinoService {

    private final DestinoRepository destinoRepository;
    private final DestinoMapper destinoMapper;

    @Autowired
    public DestinoServiceImp(DestinoRepository destinoRepository, DestinoMapper destinoMapper) {
        this.destinoRepository = destinoRepository;
        this.destinoMapper = destinoMapper;
    }

    public List<DestinoDto> getAllDestinos() {
        return destinoMapper.DestinostoDestinosDtoList(destinoRepository.findAll());
    }

    public DestinoDto getDestino(Long id) {
        Destino destino = destinoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destino no encontrado"));
        return destinoMapper.DestinoToDto(destino);
    }

    public DestinoDto saveDestino(DestinoDto dto) {
        Destino destino = destinoMapper.DestinoDtoToModel(dto);
        return destinoMapper.DestinoToDto(destinoRepository.save(destino));
    }

    public DestinoDto UpdateDestino(Long id, DestinoDto dto) {
        Destino existente = destinoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destino no encontrado"));
        destinoMapper.actualizarDesdeDto(dto, existente);
        return destinoMapper.DestinoToDto(destinoRepository.save(existente));
    }

    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}
