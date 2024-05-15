package dat3.aym.dto;

import dat3.aym.entity.OrderEntity;
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
    private OrderEntity orderEntity;
    private Product product;

    public OrderLineDto (OrderLine o){
        this.id = o.getId();
        this.qty = o.getQty();
        this.orderEntity = o.getOrderEntity();
        this.product = o.getProduct();
    }
}
