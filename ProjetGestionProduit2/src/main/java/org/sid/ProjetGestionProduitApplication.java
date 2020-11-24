package org.sid;

import org.sid.service.ProduitRestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("org.sid.entities")
@EnableJpaRepositories

public class ProjetGestionProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetGestionProduitApplication.class, args);
	}

}
