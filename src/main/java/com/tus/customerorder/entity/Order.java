package com.tus.customerorder.entity;
import jakarta.persistence.*; 
import java.time.LocalDate;

@Entity @Table(name = "orders") // avoid SQL keyword conflict and order is child 
public class Order {	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private LocalDate orderDate; 
	private Double amount;
	
	@ManyToOne //each order belongs to one customer
	@JoinColumn(name = "customer_id") //FK in h2 database
	private Customer customer;
	
	//constructors
	
	public Order() {}
	
	public Order(Long id, LocalDate orderDate, Double amount, Customer customer) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.amount = amount;
		this.customer = customer;
	}
		
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
