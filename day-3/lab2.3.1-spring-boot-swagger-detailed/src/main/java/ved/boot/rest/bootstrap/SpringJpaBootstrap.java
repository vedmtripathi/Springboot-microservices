package ved.boot.rest.bootstrap;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ved.boot.rest.domain.Product;
import ved.boot.rest.repositories.ProductRepository;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
	}

	/**
	 * 
	 */
	private void loadProducts() {
		
		Product aspirant = new Product();
		
		aspirant.setDescription("Robotics");
		aspirant.setPrice(new BigDecimal("18.95"));
		aspirant.setImageUrl(null);
		aspirant.setProductId("235268845711068308");
		
		productRepository.save(aspirant);

		log.info("Saved stream- id: " + aspirant.getId());

		Product stream = new Product();
		
		stream.setDescription("Linux Kali using Robotics ");
		stream.setImageUrl(null);
		stream.setProductId("168639393495335947");
		stream.setPrice(new BigDecimal("11.95"));
		productRepository.save(stream);

		log.info("Saved this - id:" + stream.getId());
	}

}
