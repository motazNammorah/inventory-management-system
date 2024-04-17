package org.example.inventorymangmentsystem.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    List<Items>items;


    public Supplier(int supplierId) {
        this.supplierId = supplierId;
    }

    public Supplier(){

    }



    public Supplier(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
