package ved.boot.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ved.boot.rest.Greeting;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	/**
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(path = "/greeting")
	public HttpEntity<Greeting> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
}
