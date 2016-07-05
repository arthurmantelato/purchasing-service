package br.com.ecommerce.domain.purchase;

import java.util.Collection;
import java.util.Optional;

public interface PurchaseDetailRepository {
	
	/***
	 * Finds an purchase detail with the given identification
	 * 	
	 * @param id
	 * @return The purchase detail, otherwise null
	 */
	public Optional<PurchaseDetail> findById(Long id);
	
	/***
	 * Find all purchase details related to given purchase
	 * 
	 * @param purchase
	 * @return Related purchase details if found, otherwise null
	 */
	public Collection<PurchaseDetail> findByPurchaseId(Purchase purchase);
	
	/***
	 * Fetches all purchases details known to the system
	 * 
	 * @return All purchases details
	 */
	public Collection<PurchaseDetail> findAll();
	
	/***
	 * 	Fetches the number of all purchases details known to the system 
	 * 
	 * @return The number of purchases details
	 */
	public int countAll();
	
	/***
	 * Saves the given purchase detail. Creates if new or updates if it already exists
	 * 
	 * @param purchaseDetail
	 * @return Saved purchase detail
	 */
	public PurchaseDetail merge(PurchaseDetail purchaseDetail);

}
