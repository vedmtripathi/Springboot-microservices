package ved.boot.mvc;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Ved Tripathi
 *
 */
public class Account implements BeanNameAware, ApplicationContextAware, InitializingBean {

	final static Logger LOG = Logger.getLogger(Account.class);

	String test = "working";
	float amt;
	String beanName;
	ApplicationContext ctx;
	
	public Account() {
		LOG.debug("step1...initialize");

		/*
		 * if (LOG.isDebugEnabled()) { LOG.debug("This is debug : " + test); }
		 * 
		 * if (LOG.isInfoEnabled()) { LOG.info("This is info : " + test); }
		 */

	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
		LOG.debug("step2.. DI");
	}

	public void setBeanName(String arg0) {
		beanName = arg0;
		LOG.debug("step3...BeanNameAware");
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		LOG.debug("step5...@PostConstruct");
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {  
		// TODO Auto-generated method stub
		ctx = arg0;
		LOG.debug("step4...ApplicationContextAware");
	}

	public void start() {
		LOG.debug("step7...custom initialize");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		LOG.debug("step6...initialize");

	}

}
