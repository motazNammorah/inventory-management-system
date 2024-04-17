package org.example.inventorymangmentsystem.Controller;

import org.example.inventorymangmentsystem.Entity.Customer;
import org.example.inventorymangmentsystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "customer")
@RestController
public class CustoemrCntroller {

    @Autowired
    CustomerService customerService;


    @GetMapping("/getCustoemrs")
    public ResponseEntity<List<Customer>> getData(){
        List<Customer>list=customerService.getCustomers();

        return ResponseEntity.ok().body(list);



    }


    @GetMapping("/getCustomer/{id}")
    public  ResponseEntity<Customer>getCustomer(@PathVariable int id ){
        Customer customer=customerService.getOneCustomer(id);
        return  ResponseEntity.ok(customer);
    }


    @PostMapping("/insertCustomer")
    public ResponseEntity<Void>insertCsutomer(@RequestBody Customer customer){
        customerService.insertCustoemr(customer);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Boolean>deleteCustomer(@PathVariable int id){
        boolean delete=customerService.deleteCustoemr(id);
       return ResponseEntity.ok(delete);
    }





    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<Boolean>updateCustomer(@PathVariable int id ,@RequestBody Customer customer){
        boolean updateCustomer=customerService.updateCustomer(id,customer);
        return  ResponseEntity.ok(updateCustomer);
    }

}
