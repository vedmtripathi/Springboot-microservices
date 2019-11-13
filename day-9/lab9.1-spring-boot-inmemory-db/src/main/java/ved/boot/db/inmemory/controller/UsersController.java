package ved.boot.db.inmemory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ved.boot.db.inmemory.model.Users;
import ved.boot.db.inmemory.repository.UserJpaRespository;

/**
 * 
 * @author Ved
 *
 */

@RestController
@RequestMapping("/users")   
public class UsersController {

	@Autowired
	private UserJpaRespository userJpaRespository;

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/all")  
	public List<Users> findAll() {
		
		return userJpaRespository.findAll();  
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(value = "/{name}")
	public Users findByName(@PathVariable final String name) {
		return userJpaRespository.findByName(name);
	}

	/**
	 * 
	 * @param users
	 * @return
	 */
	@PostMapping(value = "/load")
	public Users load(@RequestBody final Users users) {
		
		userJpaRespository.save(users);
		
		return userJpaRespository.findByName(users.getName());
	}
}
