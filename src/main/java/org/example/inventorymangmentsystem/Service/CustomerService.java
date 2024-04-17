package org.example.inventorymangmentsystem.Service;

import org.example.inventorymangmentsystem.Entity.Customer;
import org.example.inventorymangmentsystem.Repositry.CustomerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositry customerRepositry;


    public List<Customer> getCustomers() {
       List<Customer>list=customerRepositry.findAll();
       System.out.println(list);
       return  list;

    }

    public void insertCustoemr(Customer customer) {
        customerRepositry.save(customer);

    }

    public boolean deleteCustoemr(int id) {

        Customer customer=getOneCustomer(id);
        if(customer!=null){
            customerRepositry.deleteById(id);
            return  true;
        }else{
            return  false;
        }

    }

    public Customer getOneCustomer(int id) {
        List<Customer>customers=customerRepositry.findAll();
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getCustomerId()==id){
                return  customers.get(i);
            }
        }

        return  null;



    }

    public boolean updateCustomer(int id, Customer customer) {
    Customer temp=getOneCustomer(id);
    if(temp!=null){
        temp.setCustomerPhone(customer.getCustomerPhone());
        temp.setCustomername(customer.getCustomername());
        customerRepositry.save(temp);
        return  true;
    }else{
        return  false;
    }

    }


}
