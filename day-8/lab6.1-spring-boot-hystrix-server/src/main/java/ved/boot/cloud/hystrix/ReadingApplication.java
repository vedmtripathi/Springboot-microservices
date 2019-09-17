package ved.boot.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ReadingApplication {

//	@Autowired
//	private BookService bookService;
//
//	@Bean
//	public RestTemplate rest(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@RequestMapping("/to-read")
//	public String toRead() {
//		return bookService.readingList();
//	}

	public static void main(String[] args) {
		SpringApplication.run(ReadingApplication.class, args);
	}
}
