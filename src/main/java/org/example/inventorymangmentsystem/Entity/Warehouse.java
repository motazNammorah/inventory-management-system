package org.example.inventorymangmentsystem.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouseid;

    @Column
    private int capacity;

    @Column
    private String location;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "warehouse_items",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Items> items;


    public Warehouse(int capacity, String location, String name, List<Items> items) {
        this.capacity = capacity;
        this.location = location;
        this.name = name;
        this.items = items;
    }

    public Warehouse(int capacity, String location, String name) {
        this.capacity = capacity;
        this.location = location;
        this.name = name;
    }

    public  Warehouse(){}

    public int getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(int warehouseid) {
        this.warehouseid = warehouseid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseid=" + warehouseid +
                ", capacity=" + capacity +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
