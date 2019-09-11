package ved.boot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

//	@GetMapping("/")
	// here will get exception, as we already have mapping with this name
//	public String greetings() {
	
	/*
	 * public String serverGretings() { return
	 * "... packaged as WAR for custom deployment !!!"; }
	 */

}
