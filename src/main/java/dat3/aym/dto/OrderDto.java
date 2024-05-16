package dat3.aym.dto;

import dat3.aym.entity.OrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private int id;
    private LocalDateTime created;
    private Boolean isShipped;
    private String username;
    private int customerNumber;

    public OrderDto(OrderEntity o) {
        this.id = o.getId();
        this.created = o.getCreated();
        this.isShipped = o.isShipped();
        this.username = o.getUser().getUsername(); // Get username
        this.customerNumber = o.getUser().getCustomerNumber(); //get customernumber
    }
}
