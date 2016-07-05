package br.com.ecommerce.domain.purchase;

import java.time.Instant;
import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.ecommerce.serialization.InstantJsonSerialization;

//@Entity
public class Purchase {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productType;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = InstantJsonSerialization.InstantSerializer.class)
	@JsonDeserialize(using = InstantJsonSerialization.InstantDeserializer.class)
	private Instant expiration;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase")
	private Collection<PurchaseDetail> details;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Instant getExpiration() {
		return expiration;
	}

	public void setExpiration(Instant expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return String.format("Purchase{id=%d, productType=%s, expiration=%s, details=%s}", id, productType, expiration,
				getDetails());
	}

	public Collection<PurchaseDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<PurchaseDetail> details) {
		this.details = details;
	}
}
