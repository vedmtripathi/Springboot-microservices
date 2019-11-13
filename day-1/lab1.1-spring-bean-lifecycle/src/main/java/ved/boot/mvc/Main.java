package ved.boot.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Ved Tripathi
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Account acc = (Account) factory.getBean("account");

	}

}
