package br.com.ecommerce.services.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import br.com.ecommerce.configuration.PurchasingServerConfiguration;
import br.com.ecommerce.configuration.RepositoriesMockConfiguration;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import({ PurchasingServerConfiguration.class, RepositoriesMockConfiguration.class })
public class PurchasingServer {

	private static Logger logger = LoggerFactory.getLogger(PurchasingServer.class);

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "purchasing-server");
		SpringApplication.run(PurchasingServer.class, args);
		logger.info("Purchasing server started.");
	}
}
