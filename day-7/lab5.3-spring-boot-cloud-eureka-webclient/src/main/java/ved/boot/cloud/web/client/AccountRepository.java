
package ved.boot.cloud.web.client;

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
