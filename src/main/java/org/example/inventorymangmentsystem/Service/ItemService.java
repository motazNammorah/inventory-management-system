package org.example.inventorymangmentsystem.Service;

import org.example.inventorymangmentsystem.Entity.Items;
import org.example.inventorymangmentsystem.Entity.Supplier;
import org.example.inventorymangmentsystem.Repositry.ItemRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepositry itemRepositry;
    public List<Items> getItems() {
        List<Items>items=itemRepositry.findAll();

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n"+ items.size()+"\n-------------------------------------------------------------------------------------------------------------");
        return  items;

    }

    public void insertItem(Items item) {

        itemRepositry.save(item);

    }

    public boolean deleteItem(int id) {
        List<Items>list=itemRepositry.findAll();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getItemId()==id){
                itemRepositry.deleteById(id);
                return  true;
            }
        }
        return  false;

    }

    public Items getItem(int id) {

        List<Items>list=getItems();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getItemId()==id){
                return  list.get(i);
            }
        }
        return  null;
    }

    public boolean updateItem(int id, Items item) {
        List<Items>list=getItems();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getItemId()==id){

                Optional<Items> item1=itemRepositry.findById(id);
                item1.get().setItemname(item.getItemname());
                item1.get().setItemprice(item.getItemprice());
                item1.get().setItemdescription(item.getItemdescription());
                itemRepositry.save(item1.get());
                return  true;
            }
        }
        return  false;
    }
}
