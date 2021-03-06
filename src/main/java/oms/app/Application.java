package oms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableEntityLinks;

@ComponentScan("oms")
@EntityScan(basePackages="oms.model")
@EnableEntityLinks
@EnableJpaRepositories(basePackageClasses={oms.repository.UserRepository.class})
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
