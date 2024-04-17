package org.example.inventorymangmentsystem.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int itemId;

    @Column
    private String itemname;
    @Column
    private int itemprice;
    @Column
    private String itemdescription;


@ManyToMany(mappedBy = "items")
private List<Customer> customers;

@ManyToMany(mappedBy = "items")
private  List<Warehouse>warehouses;

@ManyToOne()
Supplier supplier;

    public Items(String itemName, int itemPrice, String itemDescription, List<Customer> customers, List<Warehouse> warehouses, Supplier supplier) {
        this.itemname = itemName;
        this.itemprice = itemPrice;
        this.itemdescription = itemDescription;
        this.customers = customers;
        this.warehouses = warehouses;
        this.supplier = supplier;
    }

    public Items(String itemname, int itemprice, String itemdescription) {
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemdescription = itemdescription;
    }

    public Items(String itemname, int itemprice, String itemdescription,Supplier supplier) {
        this.supplier = supplier;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemdescription = itemdescription;
    }

    public Items(){

    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemName) {
        this.itemname = itemName;
    }

    public int getItemprice() {
        return itemprice;
    }

    public void setItemprice(int itemPrice) {
        this.itemprice = itemPrice;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemDescription) {
        this.itemdescription = itemDescription;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                ", itemdescription='" + itemdescription + '\'' +
                ", customers=" + customers +
                ", warehouses=" + warehouses +
                ", supplier=" + supplier +
                '}';
    }
}
