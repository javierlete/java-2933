package pruebaturismo.Inyeciones.Services.Paquetes;

import pruebaturismo.Dtos.Paquetes.ReservaDto;

import java.util.List;

public interface ReservaService {

    ReservaDto getReserva(Long id);

    ReservaDto saveReserva(ReservaDto reserva);

    void deleteReserva(Long id);

    List<ReservaDto> getAllReservas();

    ReservaDto UpdateReserva(Long id, ReservaDto reserva);
}
