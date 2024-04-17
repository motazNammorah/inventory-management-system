package org.example.inventorymangmentsystem.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column
    private String customername;
    @Column
    private String customerPhone;

//    @ManyToMany(mappedBy = "customer",cascade = CascadeType.MERGE)
//     List<Items>items;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_items",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Items> items;




    public Customer(int customerId, String customerNamre, String customerPhone) {
        this.customerId = customerId;
        this.customername = customerNamre;
        this.customerPhone = customerPhone;
    }

    public Customer( String customerNamre, String customerPhone, List<Items> items) {
        this.customername = customerNamre;
        this.customerPhone = customerPhone;
        this.items = items;
    }

    public Customer(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customerNamre) {
        this.customername = customerNamre;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNamre='" + customername + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
