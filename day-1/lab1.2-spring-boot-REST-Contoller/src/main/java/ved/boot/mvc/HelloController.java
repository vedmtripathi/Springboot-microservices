package ved.boot.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Ved Tripathi
 *
 */

//@Controller
@RestController
public class HelloController {
	
	final static Logger LOG = Logger.getLogger(HelloController.class);
	
	/**
	 * 
	 * @param model
	 * @param name
	 * @return
	 */
	 @GetMapping("/hello")
//    @RequestMapping("/hello")
//	@ResponseBody
    public String hello(Model model, @RequestParam(value="name", required=false,
                                   defaultValue="World") String name) {
        model.addAttribute("name", name);
        
        LOG.debug("final msg is--> "+ "hello"+"--"+name);
        
        LOG.debug("final msg is from logger--> "+ "hello"+"--"+name);
        
        return "hello there again---"+"--"+name;
    }
    
}
