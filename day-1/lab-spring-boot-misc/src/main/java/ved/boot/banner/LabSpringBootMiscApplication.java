package ved.boot.banner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author Ved Tripathi
 *
 */

@SpringBootApplication
public class LabSpringBootMiscApplication implements CommandLineRunner {

	final static Logger LOG = Logger.getLogger(LabSpringBootMiscApplication.class);

	public static void main(String[] args) {

		// can change, SpringApplication defaults, you can instead
		// create a local instance and
		// customize it.
		SpringApplication app = new SpringApplication(LabSpringBootMiscApplication.class);

		// uncomment below line to disable - Banner Mode
//		app.setBannerMode(Mode.OFF);
		app.run(args);
		
		// uncomment below line for- Shutdown Hook
//		System.exit(SpringApplication
//				.exit(SpringApplication.run(LabSpringBootMiscApplication.class, args)));

	}

	@Override
	public void run(String... args) throws Exception {

		LOG.debug("CommandLineRunner.... working treat as init!!!");

	}

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		
		LOG.debug("Shutdown Hook.... working !!!");
		
		return () -> 42;
	}

}
