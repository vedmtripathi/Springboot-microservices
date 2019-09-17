
package ved.boot.cloud.microservice;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Ved Tripathi
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class Lambok_Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long amount;
	private String number;
	private String name;

	public Lambok_Account(Long amount, String name, String number) {
		super();
		this.amount = amount;
		this.number = number;
		this.name = name;
	}

	// NOTE: no need for manual creation of - getter/setter

	@Override
	public String toString() {
		return "Account [amount=" + amount + ", number=" + number + ", name=" + name + "]";
	}

}
