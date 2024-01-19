package hello.shopservice.main.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private static final Map<Long, ItemDto> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

//    Create
    public ItemDto saveItem(ItemDto itemDto){
        itemDto.setId(++sequence);
        store.put(itemDto.getId(), itemDto);
        return itemDto;
    }

    public ItemDto updateItem(ItemDto item){
        store.put(item.getId(),item);
        return item;
    }

    public ItemDto findById(Long id){
        return store.get(id);
    }

    public List<ItemDto> findAll() {
        return new ArrayList<>(store.values());
    }

    /*
    Delete
     */
    public void deleteItem(Long id){
        store.remove(id);
    }





}
