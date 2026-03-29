
package com.tus.customerorder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//This is used for incoming JSON request from client
//This is what the client sent when creating customer
public class CustomerCreateDTO {
	
	//Does NOT expose internal fields like id or orders
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    
    public CustomerCreateDTO() {}; 	

	public String getName() {		
		return name;
	}
	public String getEmail() {		
		return email;
	}
	

   
}
