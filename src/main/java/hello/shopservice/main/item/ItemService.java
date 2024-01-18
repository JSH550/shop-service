package hello.shopservice.main.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Long addItem(String itemName, int price, Integer quantity){
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        Item savedItem = itemRepository.saveItem(item);
        return savedItem.getId();

    }

    //모든아이템 색인
    public List<Item> findAllItems(){
        List<Item> allItemList = itemRepository.findAll();
        return  allItemList;

    }

    public Item finditemById(Long id){
       Item item = itemRepository.findById(id);
        return item;

    }

    //아이템수정
    public Long editItem(Long id, String itemName, int price, Integer quantity){

        Item item = itemRepository.findById(id);
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        Item savedItem = itemRepository.saveItem(item);
        return savedItem.getId();

    }

}
