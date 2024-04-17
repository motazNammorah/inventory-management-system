package org.example.inventorymangmentsystem.Controller;


import org.example.inventorymangmentsystem.Entity.Items;
import org.example.inventorymangmentsystem.Entity.Supplier;
import org.example.inventorymangmentsystem.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "item")
@RestController
public class ItemController {


    @Autowired
    ItemService itemService;


    @GetMapping("/getItems")
    public ResponseEntity<List<Items>>getItem(){
        List<Items>items=itemService.getItems();
        return  ResponseEntity.ok(items);
    }

    @PostMapping("/insertItem")
    public ResponseEntity<Void>insertItem(@RequestBody Items item){
        System.out.println(item.toString());
        itemService.insertItem(item);
        return  ResponseEntity.ok().build();

    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<Boolean>deleteItem(@PathVariable int id ){
        boolean isDeleteed=itemService.deleteItem(id);
        return  ResponseEntity.ok(isDeleteed);

    }

    @GetMapping("getItem/{id}")
    public ResponseEntity<Items>getoneItemO(@PathVariable int id){
        Items items=itemService.getItem(id);
        return  ResponseEntity.ok(items);
    }


    @PutMapping("/updateItem/{id}")
    public ResponseEntity<Boolean>updateItem(@PathVariable int id ,@RequestBody Items item){
        boolean updateItem=itemService.updateItem(id,item);
        return  ResponseEntity.ok(updateItem);
    }

}
