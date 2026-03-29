package com.tus.customerorder.service;

import com.tus.customerorder.dto.CustomerDTO;
import com.tus.customerorder.dto.CustomerCreateDTO;
import com.tus.customerorder.entity.Customer;
import com.tus.customerorder.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 1) Create a new customer
    public CustomerDTO createCustomer(CustomerCreateDTO dto) {

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setCreatedAt(LocalDate.now());

        Customer saved = customerRepository.save(customer);

        return convertToDTO(saved);
    }

    // 2) Get a single customer by ID
    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return convertToDTO(customer);
    }

    // 3) Get all customers
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 4) Delete customer
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    // Helper: Convert Entity → DTO
    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getCreatedAt()
        );
    }
}
