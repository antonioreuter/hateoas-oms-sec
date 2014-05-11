package oms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("oms")
@EnableAutoConfiguration
//@EnableHypermediaSupport(type = HypermediaType.HAL)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
