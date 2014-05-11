package oms.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String description;
	
	private BigDecimal price;
	
	public Product() {
		
	}
	
	public Product(Long id ,String description, BigDecimal price) {
		this.setId(id);
		this.setDescription(description);
		this.setPrice(price);
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
