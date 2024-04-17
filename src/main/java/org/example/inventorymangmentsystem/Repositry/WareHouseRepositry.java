package org.example.inventorymangmentsystem.Repositry;

import org.example.inventorymangmentsystem.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WareHouseRepositry extends JpaRepository<Warehouse,Integer> {
}
