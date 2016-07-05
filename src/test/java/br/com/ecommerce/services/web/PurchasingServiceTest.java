package br.com.ecommerce.services.web;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ecommerce.configuration.PurchasingServerConfiguration;
import br.com.ecommerce.configuration.RepositoriesTestConfiguration;
import br.com.ecommerce.domain.purchase.Purchase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { PurchasingServerConfiguration.class, RepositoriesTestConfiguration.class })
public class PurchasingServiceTest {

	@Autowired
	private PurchaseService service;
	
	@Test
	public void testFindWithIdOne() {
		Purchase purchase = service.findById(new Long(1));
		Assert.assertNotNull(purchase);
		Assert.assertEquals(new Long(1), purchase.getId());
	}
	
	@Test
	public void testFindAll() {
		List<Purchase> purchases = (List<Purchase>) service.findAll();
		Assert.assertNotNull(purchases);
		Assert.assertEquals(purchases.size(), 10);
	}
	
	@Test
	public void testCountAll() {
		Assert.assertEquals(service.countAll(), 10);
	}
	
	@Test
	public void testFindAllValid() {
		Assert.assertEquals(service.findAllValid().size(), 5);
	}
}