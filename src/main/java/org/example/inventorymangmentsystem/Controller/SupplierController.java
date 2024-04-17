package org.example.inventorymangmentsystem.Controller;

import org.example.inventorymangmentsystem.Entity.Customer;
import org.example.inventorymangmentsystem.Entity.Supplier;
import org.example.inventorymangmentsystem.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "supplier")
@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getSuppliers")
    public ResponseEntity<List<Supplier>>getSuppler(){
        List<Supplier>list=supplierService.getSupplier();
        return  ResponseEntity.ok(list);

    }

    @PostMapping("/insertSupplier")
    public  ResponseEntity<Void>insertSupplier(@RequestBody Supplier supplier){

        supplierService.insertSupplier(supplier);
        return  ResponseEntity.ok().build();
    }
    @GetMapping("/getSupplier/{id}")
    public ResponseEntity<Supplier>getCustomer(@PathVariable int id ){
        return  ResponseEntity.ok(supplierService.getOneSuppler(id));
    }


    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<Boolean>deleteCustomer(@PathVariable int id ){
        boolean isDeleteed=supplierService.deleteSuppler(id);
        if(isDeleteed==true){
            return  ResponseEntity.ok(isDeleteed);
        }else{
            return  ResponseEntity.ok(isDeleteed);
        }
    }




    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity<Boolean>updateSupplier(@PathVariable int id ,@RequestBody Supplier supplier){
        boolean updateSuppler=supplierService.updateSuppler(id,supplier);
        return  ResponseEntity.ok(updateSuppler);
    }

}
