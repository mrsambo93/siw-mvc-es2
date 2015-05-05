package it.uniroma3.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar creationTime;
	@ManyToOne
	private Customer customer;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	public Order() {
		this.orderLines = new ArrayList<>();
	}
	
	public Order(GregorianCalendar ceationTime, Customer customer) {
		this.creationTime = ceationTime;
		this.customer = customer;
		this.orderLines = new ArrayList<>();
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public GregorianCalendar getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(GregorianCalendar creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Order [creationTime=" + creationTime + ", customer=" + customer
				+ ", orderLines=" + orderLines + "]";
	}
	
}
