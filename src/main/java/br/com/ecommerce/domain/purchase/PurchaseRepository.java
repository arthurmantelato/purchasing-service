package br.com.ecommerce.domain.purchase;

import java.util.Collection;
import java.util.Optional;

public interface PurchaseRepository {
	
	/***
	 * Finds an purchase with the given identification
	 * 
	 * @param id
	 * @return The purchase, otherwise null
	 */
	public Optional<Purchase> findById(Long id);
	
	/***
	 * Fetches all purchases known to the system
	 * 
	 * @return All purchases
	 */
	public Collection<Purchase> findAll();
	
	/***
	 * Fetches the number of all purchases known to the system
	 * 
	 * @return The number of purchases
	 */
	public int countAll();
	
	/***
	 * Saves the given purchase. Creates if new or updates if it already exists
	 * 
	 * @param purchase
	 * @return Saved purchase
	 */
	public Purchase merge(Purchase purchase);

	
}
