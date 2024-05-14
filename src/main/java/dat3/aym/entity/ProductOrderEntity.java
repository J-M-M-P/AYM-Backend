package dat3.aym.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qty;
    @ManyToOne
    @JoinColumn(name = "order_id_fk")
    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "product_id_fk")
    private Product product;
}
