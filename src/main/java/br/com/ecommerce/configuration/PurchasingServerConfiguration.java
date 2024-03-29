package br.com.ecommerce.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.ecommerce.services.web.PurchaseService;
import br.com.ecommerce.services.web.PurchasingController;

@Configuration
public class PurchasingServerConfiguration {
	
	@Bean
	public PurchasingController purchasingController() {
		return new PurchasingController();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean 
	public PurchaseService purchasingService() {
		return new PurchaseService();
	}
	
	@Bean
	public DataSource dataSource() {
		return null;
	}
	
}
