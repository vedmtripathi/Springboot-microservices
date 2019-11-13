package ved.boot.exceptionhandling;

/**
 * 
 * @author Ved Tripathi
 *
 */

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
