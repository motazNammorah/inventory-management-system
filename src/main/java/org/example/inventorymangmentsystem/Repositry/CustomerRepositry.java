package org.example.inventorymangmentsystem.Repositry;

import org.example.inventorymangmentsystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {
}
