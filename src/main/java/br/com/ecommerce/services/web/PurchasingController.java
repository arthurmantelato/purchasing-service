package br.com.ecommerce.services.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.domain.purchase.Purchase;

@RestController
@RequestMapping("/purchases")
public class PurchasingController {

	@Autowired
	public PurchaseService purchaseService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		Collection<Purchase> purchases = purchaseService.findAll();
		if(purchases != null && !purchases.isEmpty()) {
			return new ResponseEntity<>(purchases, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/actives", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAllActives() {
		Collection<Purchase> purchases = purchaseService.findAllValid();
		if(purchases != null && !purchases.isEmpty()) {
			return new ResponseEntity<>(purchases, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("purchaseId") Long id) {
		Purchase purchase = purchaseService.findById(id);
		if(purchase != null) {
			return new ResponseEntity<>(purchase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Purchase purchase) {
		Purchase created = purchaseService.save(purchase);
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> update(@RequestBody Purchase purchase) {
		Purchase saved = purchaseService.save(purchase);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	
}