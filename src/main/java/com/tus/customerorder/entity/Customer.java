package com.tus.customerorder.entity;
import jakarta.persistence.*; 
import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.List;

@Entity // table will be created automatically and customer is parent table
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String name; 
	private String email; 
	private LocalDate createdAt;
	
	//one to many relationship one customer has many orders 
	//CascadeType all -> will delete customers with belonging orders
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) 
	
	private List<Order> orders = new ArrayList<>();
	
	//constructor	
	public Customer(Long id, String name, String email, LocalDate createdAt, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.orders = orders;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	//getters and setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}
