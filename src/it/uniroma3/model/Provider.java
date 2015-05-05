package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Provider {

	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String vatin;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	@ManyToMany
    private List<Product> products;
	
	public Provider() {
		this.products = new ArrayList<>();
	}
	
	public Provider(String name, String phoneNumber, String email, String vatin, Address address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vatin = vatin;
		this.address = address;
		this.products = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProducts(Product product) {
		this.products.add(product);
	}
}
