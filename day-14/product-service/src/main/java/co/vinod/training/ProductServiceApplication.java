package co.vinod.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This instructs spring to auto instantiate and load objects (beans) of components.
// Component class is annotated with @Component, @Service, @Repository, @Controller, @RestController, @Configuration
// Component scan is done only for the classes that exist inside co.vinod.training or any of its subpackages
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
