package com.tus.customerorder.controller;

import com.tus.customerorder.dto.CustomerDTO;
import com.tus.customerorder.dto.CustomerCreateDTO;
import com.tus.customerorder.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerservice;

    public CustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    // 1) Create customer
    @PostMapping("/createcustomer")
    public CustomerDTO createCustomer(@RequestBody CustomerCreateDTO dto) {
        return customerservice.createCustomer(dto);
    }

    // 2) Get customer by ID
    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerservice.getCustomer(id);
    }

    // 3) Get all customers
    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers() {
        return customerservice.getAllCustomers();
    }

    // 4) Delete customer 
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerservice.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}