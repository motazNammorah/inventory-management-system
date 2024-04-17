package org.example.inventorymangmentsystem.Service;

import org.example.inventorymangmentsystem.Entity.Items;
import org.example.inventorymangmentsystem.Entity.Warehouse;
import org.example.inventorymangmentsystem.Repositry.WareHouseRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    WareHouseRepositry wareHouseRepositry;
    public List<Warehouse> getWarehouse() {
        List<Warehouse>list=wareHouseRepositry.findAll();
        return  list;


    }

    public void insertWareHouse(Warehouse warehouse) {

        wareHouseRepositry.save(warehouse);
    }

    public Warehouse getWareHouse(int id) {

        List<Warehouse>list=getWarehouse();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWarehouseid()==id){
                return  list.get(i);
            }
        }

        return  null;
    }

    public boolean deleteWarehouse(int id) {
        List<Warehouse>list=getWarehouse();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWarehouseid()==id){
                wareHouseRepositry.deleteById(id);
                return  true;
            }
        }
        return  false;
    }

    public boolean updateWarehouse(int id, Warehouse warehouse) {
        List<Warehouse>list=getWarehouse();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWarehouseid()==id){
                Warehouse warehouse1=getWareHouse(id);
                warehouse1.setCapacity(warehouse.getCapacity());
                warehouse1.setItems(warehouse.getItems());
                warehouse1.setLocation(warehouse.getLocation());
                warehouse1.setName(warehouse.getName());
                wareHouseRepositry.save(warehouse1);
                return  true;
            }
        }
        return  false;
    }
}
