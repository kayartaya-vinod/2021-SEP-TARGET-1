package co.vinod.training;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
public class HelloServiceApplication {

    @GetMapping(path="/api/hello", produces = "application/json")
    public Map<String, Object> handleGetHelloMessage(
            @RequestParam(required = false, defaultValue = "friend") String name) {
		log.debug("Received '{}' for name", name);

		Map<String, Object> map = new LinkedHashMap<>();
        map.put("message", String.format("Hello, %s!", name));
        map.put("timestamp", new Date());
        map.put("success", true);

		log.debug("responding to the client with {}", map);
        return map;
    }

    public static void main(String[] args) {
		log.debug("Starting HelloServiceApplication");
        SpringApplication.run(HelloServiceApplication.class, args);
		log.debug("HelloServiceApplication started");
    }

}
