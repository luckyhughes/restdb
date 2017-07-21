package restwebapp.restdatabase1.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("restwebapp.restdatabase1.controller")
@EnableJpaRepositories(basePackages = "restwebapp.restdatabase1.repository")
@EntityScan("restwebapp.restdatabase1.domain")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
