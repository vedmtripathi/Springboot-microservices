package ved.boot.db.inmemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ved.boot.db.inmemory.model.Users;

/**
 * 
 * @author Ved
 *
 */

@Repository
//@Component
public interface UserJpaRespository extends JpaRepository<Users, Long>{

	/**
	 * custom method, that will request JPA to create a query on user behalf 
	 * 
	 * @param name
	 * @return
	 */
    Users findByName(String name);
    
    
    Users findBySalary(String name);
    
    
    
    
    // CRUD
    // C - create - saveXX()  -- 
    // R - retrieve - findxx()
    // U - update - savexx() -- CRUD
    // D - deete - deleteName(String s)
    
    
}
