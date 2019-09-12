
package ved.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class HelloWorldController {

	@GetMapping(value = "/helloworld")
	public ModelAndView hello() {

		String helloWorldMessage = "Hello from controller !!!";
		return new ModelAndView("hello", "message", helloWorldMessage);
	}
}
