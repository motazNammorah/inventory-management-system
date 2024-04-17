package org.example.inventorymangmentsystem.Service;

import org.example.inventorymangmentsystem.Entity.Supplier;
import org.example.inventorymangmentsystem.Repositry.SupplierRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepositry supplierRepositry;
    public List<Supplier> getSupplier() {
        List<Supplier>list=supplierRepositry.findAll();
        return  list;
    }

    public void insertSupplier(Supplier supplier) {
        supplierRepositry.save(supplier);
    }


    public Supplier getOneSuppler(int id) {
        List<Supplier>suppliers=getSupplier();
        for(int i=0;i<suppliers.size();i++){
            if(suppliers.get(i).getSupplierId()==id){
                return  suppliers.get(i);
            }
        }
        return  null;
    }

    public boolean deleteSuppler(int id) {
        List<Supplier>suppliers=getSupplier();
        for(int i=0;i<suppliers.size();i++){
            if(suppliers.get(i).getSupplierId()==id){
                supplierRepositry.deleteById(id);
                return  true;
            }
        }
        return  false;
    }

    public boolean updateSuppler(int id, Supplier supplier) {

        List<Supplier>list=getSupplier();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getSupplierId()==id){

                Supplier supplier1=getOneSuppler(id);
                supplier1.setAddress(supplier.getAddress());
                supplier1.setEmail(supplier.getEmail());
                supplier1.setItems(supplier.getItems());
                supplier1.setName(supplier.getName());
                supplierRepositry.save(supplier1);
                return  true;
            }
        }
        return  false;
    }
}
