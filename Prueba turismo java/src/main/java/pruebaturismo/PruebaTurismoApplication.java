package pruebaturismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "pruebaturismo.Inyeciones.Repositories")
public class PruebaTurismoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTurismoApplication.class, args);
    }

}
