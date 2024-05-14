package dat3.aym.dto;

import dat3.aym.entity.OrderEntity;
import dat3.security.entity.UserWithRoles;
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
    private String username; // Brugernavn i stedet for brugerobjektet
    //private UserWithRoles user; // Hvis du vil inkludere hele brugerobjektet

    public OrderDto(OrderEntity o) {
        this.id = o.getId();
        this.created = o.getCreated();
        this.isShipped = o.getIsShipped();
        this.username = o.getUser().getUsername(); // Få brugernavnet
        //this.user = o.getUserName(); // Hvis du vil inkludere hele brugerobjektet
    }
}
