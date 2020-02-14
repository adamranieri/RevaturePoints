package dev.ranieri.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.ranieri")
@EnableJpaRepositories("dev.ranieri.repositories")
@EntityScan("dev.ranieri.entities")
public class RpasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpasApplication.class, args);
	}

}
