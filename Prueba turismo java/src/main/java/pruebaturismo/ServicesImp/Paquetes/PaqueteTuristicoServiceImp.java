package pruebaturismo.ServicesImp.Paquetes;

import pruebaturismo.Dtos.Paquetes.PaqueteTuristicoDto;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.DestinoRepository;
import pruebaturismo.Inyeciones.Repositories.Paquetes.PaqueteTuristicoRepository;
import pruebaturismo.Inyeciones.Services.Paquetes.PaqueteTuristicoService;
import pruebaturismo.Mappers.Paquetes.PaqueteTuristicoMapper;
import pruebaturismo.Models.Paquetes.PaqueteTuristico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PaqueteTuristicoServiceImp")
public class PaqueteTuristicoServiceImp implements PaqueteTuristicoService {

    private final PaqueteTuristicoRepository paqueteRepository;
    private final DestinoRepository destinoRepository;
    private final PaqueteTuristicoMapper paqueteMapper;

    @Autowired
    public PaqueteTuristicoServiceImp(PaqueteTuristicoRepository paqueteRepository, DestinoRepository destinoRepository, PaqueteTuristicoMapper paqueteMapper) {
        this.paqueteRepository = paqueteRepository;
        this.destinoRepository = destinoRepository;
        this.paqueteMapper = paqueteMapper;
    }

    // Listar todos los paquetes con relaciones
    public List<PaqueteTuristicoDto> getAllPaquetes() {
        List<PaqueteTuristico> paquetes = paqueteRepository.findAll();
        return paqueteMapper.PaquetestoPaquetesDtoList(paquetes);
    }

    // Obtener por ID con relaciones
    public PaqueteTuristicoDto getPaquete(Long id) {
        PaqueteTuristico paquete = paqueteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paquete turistico no encontrado"));
        return paqueteMapper.PaquetetoPaqueteDto(paquete);
    }

    // Crear
    public PaqueteTuristicoDto savePaquete(PaqueteTuristicoDto dto) {
        PaqueteTuristico paquete = paqueteMapper.paquetefromDto(dto);
        if (dto.getDestino_id() != null) {
            paquete.setDestino(destinoRepository.findById(dto.getDestino_id())
                    .orElseThrow(() -> new EntityNotFoundException("Destino no encontrado")));
        }
        PaqueteTuristico guardado = paqueteRepository.save(paquete);
        return paqueteMapper.PaquetetoPaqueteDto(guardado);
    }

    // Actualizar
    public PaqueteTuristicoDto UpdatePaquete(Long id, PaqueteTuristicoDto dto) {
        PaqueteTuristico existente = paqueteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paquete turistico no encontrado"));
        paqueteMapper.actualizarDesdeDto(dto, existente);
        if (dto.getDestino_id() != null) {
            existente.setDestino(destinoRepository.findById(dto.getDestino_id())
                    .orElseThrow(() -> new EntityNotFoundException("Destino no encontrado")));
        }
        PaqueteTuristico actualizado = paqueteRepository.save(existente);
        return paqueteMapper.PaquetetoPaqueteDto(actualizado);
    }

    // Eliminar
    public void deletePaquete(Long id) {
        paqueteRepository.deleteById(id);
    }
}
