package br.com.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.ecommerce.services.web.PurchasingController;
import br.com.ecommerce.services.web.PurchaseService;

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
	
}
