package br.com.ecommerce.configuration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ecommerce.domain.purchase.Purchase;
import br.com.ecommerce.domain.purchase.PurchaseDetail;
import br.com.ecommerce.domain.purchase.PurchaseRepository;

@Configuration
public class RepositoriesMockConfiguration {

	@Bean
	public PurchaseRepository purchaseRepository() {
		return new PurchaseRepository() {

			@Override
			public Purchase merge(Purchase purchase) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Optional<Purchase> findById(Long id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<Purchase> findAll() {
				boolean valid = false;
				List<Purchase> purchases = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					Purchase purchase = new Purchase();
					purchase.setId(new Long(i));
					purchase.setDetails(generateFakePurchases());
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

			private Collection<PurchaseDetail> generateFakePurchases() {
				List<PurchaseDetail> details = new ArrayList<>();
				for(int i = 0; i < 5; i++) {
					PurchaseDetail detail = new PurchaseDetail();
					detail.setId(new Long(i));
					detail.setDescription("Complete description of purchase detail #" + i);
					detail.setQuantity((i + 1) * 1000);
					detail.setValue((i + 1) * Math.PI);
					details.add(detail);
				}
				return details;
			}

			@Override
			public int countAll() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

}
