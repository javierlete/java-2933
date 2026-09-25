package pruebaturismo.ServicesImp.Paquetes;

import pruebaturismo.Dtos.Paquetes.ReservaDto;
import pruebaturismo.Inyeciones.Repositories.Paquetes.ReservaRepository;
import pruebaturismo.Inyeciones.Services.Paquetes.ReservaService;
import pruebaturismo.Mappers.Paquetes.ReservaMapper;
import pruebaturismo.Models.Paquetes.Reserva;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReservaServiceImp")
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    @Autowired
    public ReservaServiceImp(ReservaRepository reservaRepository, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    public List<ReservaDto> getAllReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservaMapper.ReservastoReservasDtoList(reservas);
    }

    public ReservaDto getReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada"));
        return reservaMapper.ReservaToDto(reserva);
    }

    public ReservaDto saveReserva(ReservaDto dto) {
        Reserva reserva = reservaMapper.ReservaDtoToModel(dto);
        Reserva guardada = reservaRepository.save(reserva);
        return reservaMapper.ReservaToDto(guardada);
    }

    public ReservaDto UpdateReserva(Long id, ReservaDto dto) {
        Reserva existente = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva no encontrada"));
        reservaMapper.actualizarDesdeDto(dto, existente);
        Reserva actualizada = reservaRepository.save(existente);
        return reservaMapper.ReservaToDto(actualizada);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
