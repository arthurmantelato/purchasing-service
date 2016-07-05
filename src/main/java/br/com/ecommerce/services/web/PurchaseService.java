package br.com.ecommerce.services.web;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.domain.purchase.Purchase;
import br.com.ecommerce.domain.purchase.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repository;

	public Purchase findById(Long id) {
		Optional<Purchase> findById = repository.findById(id);
		return findById.get();
	}

	public Collection<Purchase> findAll() {
		return repository.findAll();
	}
	
	public Collection<Purchase> findAllValid() {
		Instant now = Instant.now();
		return findAll().stream().filter(p -> (p.getExpiration().compareTo(now) < 0)).collect(Collectors.toList()); 
	}
	
	public int countAll() {
		return repository.countAll();
	}

	public Purchase save(Purchase purchase) {
		return repository.merge(purchase);
	}
	
}
