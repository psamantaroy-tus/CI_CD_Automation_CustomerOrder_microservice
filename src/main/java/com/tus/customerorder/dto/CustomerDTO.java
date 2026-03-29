package com.tus.customerorder.dto;

import java.time.LocalDate;
import java.util.List;

//This is what return from customer
public class CustomerDTO {

    private Long id;
    private String name;
   // private String email;
    private LocalDate createdAt;
   // private List<OrderDTO> orders;
    
    //constructor
    public CustomerDTO(Long id, String name, LocalDate createdAt) {
	super();
	this.id = id;
	this.name = name;
	this.createdAt = createdAt;
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
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
    
    

   
}

