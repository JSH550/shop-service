package hello.shopservice.main.item;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDto {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemDto() {

    }

    public ItemDto(Long id, String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
