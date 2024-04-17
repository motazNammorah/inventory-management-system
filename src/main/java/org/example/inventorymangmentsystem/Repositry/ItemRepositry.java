package org.example.inventorymangmentsystem.Repositry;

import org.example.inventorymangmentsystem.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepositry extends JpaRepository<Items,Integer> {
}
