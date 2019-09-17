
package ved.boot.cloud.microservice;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Ved Tripathi
 *
 */

@RestController
public class AccountController {

	protected Logger logger = Logger.getLogger(AccountController.class.getName());

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);

		logger.info("final msg is--> " + "hello" + "--" + name);

		return "hello" + "--" + name;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/accounts")
	public Account[] all() {

		logger.info("accounts-microservice all() invoked");
		
		List<Account> accounts = accountRepository.getAllAccounts();
		
		logger.info("accounts-microservice all() found: " + accounts.size());

		return accounts.toArray(new Account[accounts.size()]);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/accounts/{id}")
	public Account byId(@PathVariable("id") String id) {

		logger.info("accounts-microservice byId() invoked: " + id);
		Account account = accountRepository.getAccount(id);
		logger.info("accounts-microservice byId() found: " + account);

		return account;
	}
}
