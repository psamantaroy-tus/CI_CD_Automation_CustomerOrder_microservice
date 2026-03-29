package com.tus.customerorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tus.customerorder.entity.Customer;

//This is an interface that extends the jparepository.Jpa gives you the CURD operation and all the requiremnts for the controllers
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

