package it.uniroma3.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float unitPrice;
	private Integer quantity;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Product product;
	
	public OrderLine() {
		
	}
	
	public OrderLine(Float unitPrice, Integer quantity, Product product) {
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.product = product;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
