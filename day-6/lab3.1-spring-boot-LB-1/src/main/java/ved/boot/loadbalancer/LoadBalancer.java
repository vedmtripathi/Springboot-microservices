package ved.boot.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
@SpringBootApplication
public class LoadBalancer {

  private static Logger log = LoggerFactory.getLogger(LoadBalancer.class);
 
  @RequestMapping(value = "/greeting")
  public String greet() {
    log.info("LB-->1 -- Access /greeting");

    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
    Random rand = new Random();

    int randomNum = rand.nextInt(greetings.size());
    
    return greetings.get(randomNum) + "--LB-->1";
    
  }

  @RequestMapping(value = "/")
  public String home() {
    log.info("Access /");
    return "Hi!";
  }

  public static void main(String[] args) {
    SpringApplication.run(LoadBalancer.class, args);
  }
}
