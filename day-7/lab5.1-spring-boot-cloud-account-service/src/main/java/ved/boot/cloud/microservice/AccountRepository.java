
package ved.boot.cloud.microservice;

import java.util.List;

/**
 * 
 * @author Ved Tripathi
 *
 */

public interface AccountRepository {

	List<Account> getAllAccounts();

	Account getAccount(String number);
}
