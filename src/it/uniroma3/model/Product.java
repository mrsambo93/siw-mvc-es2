package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {

	private Long id;
	private String code;
	private String name;
	private String description;
	private Float price;
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<OrderLine> orderLines;
	@ManyToMany(mappedBy = "products")
    private List<Provider> providers;
	
	public Product() {
		this.orderLines = new ArrayList<>();
		this.providers = new ArrayList<>();
	}
	
	public Product(String name, String description, String code, Float price) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.orderLines = new ArrayList<>();
		this.providers = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void addProvider(Provider provider) {
		this.providers.add(provider);
	}
}
