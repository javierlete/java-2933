package pruebaturismo.ServicesImp.Nomencladores;

import pruebaturismo.Dtos.Nomencladores.GuiaDto;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.GuiaRepository;
import pruebaturismo.Inyeciones.Services.Nomencladores.GuiaService;
import pruebaturismo.Mappers.Nomencladores.GuiaMapper;
import pruebaturismo.Models.Nomencladores.Guia;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GuiaServiceImp")
public class GuiaServiceImp implements GuiaService {

    private final GuiaRepository guiaRepository;
    private final GuiaMapper guiaMapper;

    @Autowired
    public GuiaServiceImp(GuiaRepository guiaRepository, GuiaMapper guiaMapper) {
        this.guiaRepository = guiaRepository;
        this.guiaMapper = guiaMapper;
    }

    // Listar todos los guias con relaciones
    public List<GuiaDto> getAllGuias() {
        List<Guia> guias = guiaRepository.findAll();
        return guiaMapper.GuiastoGuiasDtoList(guias);
    }

    // Obtener por ID con relaciones
    public GuiaDto getGuia(Long id) {
        Guia guia = guiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guia no encontrado"));
        return guiaMapper.GuiaToDto(guia);
    }

    // Crear
    public GuiaDto saveGuia(GuiaDto dto) {
        Guia guia = guiaMapper.GuiaDtoToGuia(dto);
        Guia guardado = guiaRepository.save(guia);
        return guiaMapper.GuiaToDto(guardado);
    }

    // Actualizar
    public GuiaDto UpdateGuia(Long id, GuiaDto dto) {
        Guia existente = guiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guia no encontrado"));
        guiaMapper.actualizarDesdeDto(dto, existente);
        Guia actualizado = guiaRepository.save(existente);
        return guiaMapper.GuiaToDto(actualizado);
    }

    // Eliminar
    public void deleteGuia(Long id) {
        guiaRepository.deleteById(id);
    }
}
