package pruebaturismo.Mappers;

import pruebaturismo.Inyeciones.Repositories.Nomencladores.GuiaRepository;
import pruebaturismo.Models.Nomencladores.Guia;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuiasMapperHelper {

    @Autowired
    private GuiaRepository guiaRepository;

    @Named("mapGuiasIdsToGuias")
    public List<Guia> mapGuiasIdsToGuias(List<Long> guiasIds) {
        if (guiasIds == null) return new ArrayList<>();
        return guiaRepository.findAllById(guiasIds);
    }

    @Named("mapGuiasToGuiasIds")
    public List<Long> mapGuiasToGuiasIds(List<Guia> guias) {
        return guias.stream().map(Guia::getId).collect(Collectors.toList());
    }
}
