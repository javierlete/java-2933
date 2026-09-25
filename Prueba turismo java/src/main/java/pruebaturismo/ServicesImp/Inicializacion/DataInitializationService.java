package pruebaturismo.ServicesImp.Inicializacion;

import pruebaturismo.Enums.EstadoReserva;
import pruebaturismo.Enums.TipoPaquete;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.ClienteRepository;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.DestinoRepository;
import pruebaturismo.Inyeciones.Repositories.Nomencladores.GuiaRepository;
import pruebaturismo.Inyeciones.Repositories.Paquetes.ComentarioRepository;
import pruebaturismo.Inyeciones.Repositories.Paquetes.PaqueteTuristicoRepository;
import pruebaturismo.Inyeciones.Repositories.Paquetes.ReservaRepository;
import pruebaturismo.Models.Nomencladores.Cliente;
import pruebaturismo.Models.Nomencladores.Destino;
import pruebaturismo.Models.Nomencladores.Guia;
import pruebaturismo.Models.Nomencladores.Persona;
import pruebaturismo.Models.Paquetes.Comentario;
import pruebaturismo.Models.Paquetes.PaqueteTuristico;
import pruebaturismo.Models.Paquetes.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class DataInitializationService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DestinoRepository destinoRepository;

    @Autowired
    private GuiaRepository guiaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaqueteTuristicoRepository paqueteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    private boolean alreadySetup = false;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup || destinoRepository.count() > 0) {
            return;
        }

        Destino varadero = destinoRepository.save(new Destino("Varadero", "Cuba", true));
        Destino trinidad = destinoRepository.save(new Destino("Trinidad", "Cuba", true));

        Guia guia1 = guiaRepository.save(new Guia("Laura", "Mendez", "laura@turismo.cu", "90010112345", "Ingles", 5));
        Guia guia2 = guiaRepository.save(new Guia("Pedro", "Suarez", "pedro@turismo.cu", "88020254321", "Frances", 10));

        Cliente cliente1 = clienteRepository.save(new Cliente("Ana", "Garcia", "ana@correo.com", "95030311111", "Espanna", "+34 600000000", true));
        Cliente cliente2 = clienteRepository.save(new Cliente("John", "Smith", "john@correo.com", "93040422222", "Canada", "+1 5550000", false));

        PaqueteTuristico playa = new PaqueteTuristico("Sol y playa", "Una semana en Varadero todo incluido", 850.0, 7, TipoPaquete.PLAYA, varadero);
        playa.setGuias(List.of(guia1));
        playa = paqueteRepository.save(playa);

        PaqueteTuristico colonial = new PaqueteTuristico("Ruta colonial", "Recorrido por la ciudad de Trinidad", 420.0, 3, TipoPaquete.CULTURAL, trinidad);
        colonial.setGuias(List.of(guia1, guia2));
        colonial = paqueteRepository.save(colonial);

        crearReserva(cliente1, playa, 2, EstadoReserva.CONFIRMADA);
        crearReserva(cliente1, colonial, 2, EstadoReserva.PENDIENTE);
        crearReserva(cliente2, colonial, 1, EstadoReserva.CONFIRMADA);

        crearComentario(cliente1, playa, "Excelente playa y muy buena atencion", 5);
        crearComentario(cliente1, colonial, "Muy bonito pero mucho calor", 4);
        crearComentario(cliente2, colonial, "El guia explico todo muy bien", 5);
        crearComentario(guia1, playa, "Grupo muy agradable esta semana", 5);

        alreadySetup = true;
    }

    private void crearReserva(Cliente cliente, PaqueteTuristico paquete, int cantPersonas, EstadoReserva estado) {
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setPaquete(paquete);
        reserva.setCant_personas(cantPersonas);
        reserva.setEstado(estado);
        reserva.setFecha_reserva(new Date(System.currentTimeMillis()));
        reservaRepository.save(reserva);
    }

    private void crearComentario(Persona persona, PaqueteTuristico paquete, String texto, int puntuacion) {
        Comentario comentario = new Comentario();
        comentario.setPersona(persona);
        comentario.setPaquete(paquete);
        comentario.setTexto(texto);
        comentario.setPuntuacion(puntuacion);
        comentario.setFecha(new Date(System.currentTimeMillis()));
        comentarioRepository.save(comentario);
    }
}
