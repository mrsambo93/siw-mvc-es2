package it.uniroma3.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar dateOfBirth;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar registrationDate;
	@OneToMany
	@JoinColumn(name = "customer_id")
	private List<Order> orders;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	
	public Customer(){
		this.orders = new ArrayList<>();
	}
	
	public Customer(String firstName, String lastName, String email, String phoneNumber, GregorianCalendar dateOfBirth, GregorianCalendar registrationDate, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.address = address;
		this.orders = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GregorianCalendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(GregorianCalendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + ", registrationDate="
				+ registrationDate + ", address=" + address + "]";
	}
	
}
