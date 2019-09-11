package ved.boot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
@SpringBootApplication
// this will tell spring that I want custom config to package this app as - WAR
public class SpringBootWebApplication extends SpringBootServletInitializer {

//@ManagedResource("custom:name=spring")
//public class SpringBootWebApplication {
	
	public static void main(String[] args) {

//		set custom context path for application
//		System.setProperty("server.servlet.context-path", "/yoboot");

		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@GetMapping("/")
	public String greetings() {
		return "... on da way !!!";
	}
	
	/**
	 * set custom context path for application
	 * 
	 * @return
	 */
	
	  @Bean
	  public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
	  webServerFactoryCustomizer() { return factory ->
	  factory.setContextPath("/ved"); }
	 
}
