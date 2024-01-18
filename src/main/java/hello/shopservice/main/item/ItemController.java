package hello.shopservice.main.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/item")
@Controller
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @Autowired
    //생성자 DI
    public ItemController(ItemRepository itemRepository , ItemService itemService) {

        this.itemRepository = itemRepository;
        this.itemService=itemService;
    }

    @GetMapping()
    public String itemPage(Model model){
        model.addAttribute("data","hello");
        return "basic/item";
    };


    //item 추가 페이지
    @GetMapping("/additem")
    public String addItem(){
//        model.addAttribute("data","hello");
        return "basic/addForm";
    };
    /*
    item form으로 post 요청오면 저장
     */

    @PostMapping("/additem")
    public String addNewItem(@RequestParam String itemName,
                             @RequestParam int price,
                             @RequestParam Integer quantity){

        //Service 호출,저장
        Long addedItem = itemService.addItem(itemName, price, quantity);
        //PRG 형태로 리다이렉트
        return "redirect:/item/items/"+  addedItem;

    };

    /*
    item list 보여주기
     */

    @GetMapping("/list")
    public String showItemList(Model model){
        //리포지토리에서 데이터 다 꺼내서 저장해주세요
//        List<Item> allItemList = itemRepository.findAll();

        List<Item> allItems = itemService.findAllItems();
        model.addAttribute("items",allItems);
        System.out.println(allItems);

        return "basic/items";
    };


//   item 상세페이지 보여주기
    @GetMapping("items/{itemId}")
    public String detailItem(@PathVariable Long itemId, Model model){
        //URI의 itemId 객체에 저장
        Item findedItem = itemRepository.findById(itemId);
        model.addAttribute("item",findedItem);

        return "basic/item";
    };

    @GetMapping("/edit")
    public String editItem(@RequestParam Long itemId, Model model){
        Item item = itemService.finditemById(itemId);
        //URI의 itemId 객체에 저장
        model.addAttribute("item",item);
        return "basic/editItemForm";

    };

    @PostMapping("item/edit/{itemId}")
    public String editItem(@PathVariable Long itemId,
                           @RequestParam String itemName,
                           @RequestParam int price,
                           @RequestParam Integer quantity){
        //수정요청오면
        //repository에서 객체 찾아서
        //수정좀
        Long editedItem = itemService.editItem(itemId, itemName, price, quantity);

        return "redirect:/item/items/"+  editedItem;
    };

    @ResponseBody
    @GetMapping("/test")
    public String showItemList(@RequestParam String name){

        log.info(name);

        return "ok";

    }
}
