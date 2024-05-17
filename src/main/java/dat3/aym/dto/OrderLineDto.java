package dat3.aym.dto;

import dat3.aym.entity.OrderLine;
import dat3.aym.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLineDto {
    private int id;
    private int qty;
    private String size;
    private String color;
    private int orderId;
    private String username;
    private Product product;

    public OrderLineDto (OrderLine o){
        this.id = o.getId();
        this.qty = o.getQty();
        this.color = o.getColor();
        this.size = o.getSize();
        this.orderId = o.getOrder().getOrderId();
        this.username = o.getOrder().getUser().getUsername();
        this.product = o.getProduct();
    }
}
