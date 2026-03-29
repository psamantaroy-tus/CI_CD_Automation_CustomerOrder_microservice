package com.tus.customerorder.service;

import com.tus.customerorder.dto.OrderDTO;
import com.tus.customerorder.dto.OrderCreateDTO;
import com.tus.customerorder.entity.Customer;
import com.tus.customerorder.entity.Order;
import com.tus.customerorder.repository.CustomerRepository;
import com.tus.customerorder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // 1) Create order for a customer
    public OrderDTO createOrder(Long customerId, OrderCreateDTO dto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());
        order.setAmount(dto.getAmount());
        order.setCustomer(customer);

        Order saved = orderRepository.save(order);
        return convertToDTO(saved);
    }

    // 2) Get all orders for a customer
    public List<OrderDTO> getOrdersByCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customer.getOrders()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

   
    //3. update existing Order
    public OrderDTO updateOrder(Long orderId, OrderCreateDTO dto) {
        // Find the existing order else throw exception
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        // Update the entity fields with data from the DTO
        order.setOrderDate(dto.getOrderDate());
        order.setAmount(dto.getAmount());

        // Save the updated entity
        Order updatedOrder = orderRepository.save(order);

        //Return the result as a DTO
        return convertToDTO(updatedOrder);
    }
    
   //4. Cascade Delete order
    public void deleteOrder(Long orderId) {
        // Check if the order exists before attempting to delete
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        
        orderRepository.delete(order);
    }
    
    //5. Get order by date range filtering
    public List<OrderDTO> getOrdersByDateRange(LocalDate start, LocalDate end) {
        //Find filtered entities from repository
        List<Order> orders = orderRepository.findByOrderDateBetween(start, end);
        
        //Convert entities to DTOs for the response
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    } 
    
    //6. Get paginated orders
    public Page<OrderDTO> getPaginatedOrders(int page, int size) {
        // Create a Pageable object
        Pageable pageable = PageRequest.of(page, size);
        
        // Fetch the page of entities
        Page<Order> orderPage = orderRepository.findAll(pageable);
        
        //Map the Page of entities to a Page of DTOs
        return orderPage.map(this::convertToDTO);
    }
   
    // Helper: convert Entity → DTO showing the  data mapping logic
    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setAmount(order.getAmount());
        return dto;
    }
    
    
    

}
