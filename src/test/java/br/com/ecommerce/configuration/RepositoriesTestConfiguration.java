package br.com.ecommerce.configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ecommerce.domain.purchase.Purchase;
import br.com.ecommerce.domain.purchase.PurchaseRepository;

@Configuration
public class RepositoriesTestConfiguration {

	@Bean
	public PurchaseRepository purchaseRepository() {
		PurchaseRepository repository = Mockito.mock(PurchaseRepository.class);
		Mockito.when(repository.findAll()).thenReturn(fakePurchases());
		Mockito.when(repository.countAll()).thenReturn(fakePurchases().size());
		Mockito.when(repository.merge(Mockito.anyObject())).thenReturn(null);
		Mockito.when(repository.findById(new Long(1)))
				.thenReturn(Optional.of(((List<Purchase>) fakePurchases()).get(1)));
		return repository;
	}

	private Collection<Purchase> fakePurchases() {
		boolean valid = false;
		List<Purchase> purchases = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Purchase purchase = new Purchase();
			purchase.setId(new Long(i));
			purchase.setDetails(null);
			if (valid) {
				purchase.setExpiration(Instant.now().plus(30 + i, ChronoUnit.DAYS));
			} else {
				purchase.setExpiration(Instant.now().plus(-30 + i, ChronoUnit.DAYS));
			}
			valid = !valid;
			purchase.setProductType("productType#" + i);
			purchases.add(purchase);
		}
		return purchases;
	}
}
