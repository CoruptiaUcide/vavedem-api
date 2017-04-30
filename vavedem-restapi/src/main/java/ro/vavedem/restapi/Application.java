package ro.vavedem.restapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ro.vavedem.restapi", "ro.vavedem.interfaces", "ro.vavedem.models", 
        "ro.vavedem.services", "ro.vavedem.persistence"})
@EnableJpaRepositories(basePackages={"ro.vavedem.persistence"})
@EntityScan(basePackages = {"ro.vavedem.persistence.entities"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
