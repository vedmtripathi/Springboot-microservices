package ved.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
@SpringBootApplication
public class Application {

	// custom endpoint
	// http://localhost:9090/actuator/custom-health
	
	// Actuator at different port
	//	http://localhost:9090/admin/info
	
	// Normal Service URL at different port
	//	http://localhost:8080/hello

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/hello")
	public String greetings() {
		return "Hello: Spring Boot!";
	}

}
