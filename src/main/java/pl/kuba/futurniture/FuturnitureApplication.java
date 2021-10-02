package pl.kuba.futurniture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
@SpringBootApplication
public class FuturnitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuturnitureApplication.class, args);
    }

}
