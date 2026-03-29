package com.tus.customerorder.dto;

import java.time.LocalDate;

public class OrderDTO {
	
	private Long id;
    private LocalDate orderDate;
    private Double amount;
    
    //constructor
    public OrderDTO() {	}
    
    public OrderDTO(Long id, LocalDate orderDate, Double amount) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.amount = amount;
	}	
	
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


    
}
