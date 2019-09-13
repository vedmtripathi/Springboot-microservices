package ved.boot.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * with Actuators, if we remove this file then, will get a login page to get auth.
 * @author Ved
 *
 */

@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.authorizeRequests().antMatchers("/", "/swagger-resources").permitAll();
//		httpSecurity.csrf().disable();
//		httpSecurity.headers().frameOptions().disable();
	}

}