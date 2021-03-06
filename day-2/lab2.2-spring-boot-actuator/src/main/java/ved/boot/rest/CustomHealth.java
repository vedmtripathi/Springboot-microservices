package ved.boot.rest;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author Ved Tripathi
 *
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomHealth {

	private Map<String, Object> healthDetails;

	@JsonAnyGetter
	public Map<String, Object> getHealthDetails() {
		return this.healthDetails;
	}

	public void setHealthDetails(Map<String, Object> details) {
		this.healthDetails = details;

	}
}
