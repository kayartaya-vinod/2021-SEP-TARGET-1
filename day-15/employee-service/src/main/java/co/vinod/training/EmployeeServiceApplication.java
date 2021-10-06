package co.vinod.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2 // loads swagger beans into the container and exposes endpoints: /v2/api-docs and /swagger-ui.html
public class EmployeeServiceApplication {

    @Bean // spring container calls this method and collects/ keeps it in the container
    public Docket docket() {
        // swagger beans make use of this docket object to produce HTML documentation on the selected apis
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .paths(path -> path.startsWith("/actuator"))
                .apis(RequestHandlerSelectors.basePackage("co.vinod"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
