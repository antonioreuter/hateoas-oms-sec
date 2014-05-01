package oms.model;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

public class Item extends ResourceSupport {

	private Long itemId;

	private Product product;

	private int quantity;

	private BigDecimal price;
}
