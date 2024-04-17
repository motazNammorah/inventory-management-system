package org.example.inventorymangmentsystem.Controller;

import org.example.inventorymangmentsystem.Entity.Warehouse;
import org.example.inventorymangmentsystem.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "warehouse")
@RestController

public class WareHouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/getwarehouse")
    public ResponseEntity<List<Warehouse>>getAllDate(){
        List<Warehouse>list=warehouseService.getWarehouse();
        return  ResponseEntity.ok().body(list);
    }

    @PostMapping("/insertWarehouse")
    public ResponseEntity<Void>insertWarehouse(@RequestBody Warehouse warehouse){
//        System.out.println(warehouse.toString());
        warehouseService.insertWareHouse(warehouse);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/getOneWareHouse/{id}")
    public ResponseEntity<Warehouse>getOneWareHouse(@PathVariable int id){
        Warehouse warehouse=warehouseService.getWareHouse(id);
        return  ResponseEntity.ok(warehouse);
    }
    @DeleteMapping("/deleteWarehouse/{id}")
    public ResponseEntity<Boolean>deleteWareHouse(@PathVariable int id ){
        boolean isDeleted=warehouseService.deleteWarehouse(id);
        return  ResponseEntity.ok(isDeleted
        );

    }

    @PutMapping("/updateWarehouse/{id}")
    public ResponseEntity<Boolean>updateWarehouse(@PathVariable int id ,@RequestBody Warehouse warehouse){
        boolean isUpdate=warehouseService.updateWarehouse(id,warehouse);
        return ResponseEntity.ok(isUpdate);

    }

}
