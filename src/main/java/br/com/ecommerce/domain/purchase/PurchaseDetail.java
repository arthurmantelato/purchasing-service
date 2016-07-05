	package br.com.ecommerce.domain.purchase;

public class PurchaseDetail {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private Integer quantity;
	private Double value;

	//@ManyToOne(optional = false)
	private Purchase purchase;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("PurchaseDetail{id=%d, description=%s, quantity=%d, value=%f}", id, description, quantity,
				value);
	}

}
