package dat3.aym.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qty;
    @ManyToOne
    @JoinColumn(name = "order_id_fk")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id_fk")
    private Product product;
}
