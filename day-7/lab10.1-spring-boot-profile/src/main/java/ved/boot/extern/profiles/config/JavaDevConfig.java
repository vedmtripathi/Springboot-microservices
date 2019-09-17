package ved.boot.extern.profiles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * @author Ved
 */

@Profile("dev")
@Configuration
public class JavaDevConfig {

    @PostConstruct
    public void test() {
        System.out.println("Load data from DEV environment");
    }
}
