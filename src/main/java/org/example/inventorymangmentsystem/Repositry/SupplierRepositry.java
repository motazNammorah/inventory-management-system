package org.example.inventorymangmentsystem.Repositry;

import org.example.inventorymangmentsystem.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepositry extends JpaRepository<Supplier,Integer> {
}
