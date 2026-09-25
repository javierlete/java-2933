package pruebaturismo.Mappers;

import pruebaturismo.Models.Paquetes.PaqueteTuristico;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaquetesMapperHelper {

    @Named("mapPaquetesToPaquetesIds")
    public List<Long> mapPaquetesToPaquetesIds(List<PaqueteTuristico> paquetes) {
        if (paquetes == null) return null;
        return paquetes.stream().map(PaqueteTuristico::getId).collect(Collectors.toList());
    }
}
