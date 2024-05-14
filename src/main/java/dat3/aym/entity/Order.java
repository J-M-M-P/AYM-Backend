package dat3.aym.entity;

import dat3.security.entity.UserWithRoles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private LocalDateTime created;

 @ManyToOne
 @JoinColumn(name = "customer_user_name")
 private UserWithRoles userName;
 private boolean isShipped;

 @ManyToMany
 @JoinTable(name = "product_order_order",
         joinColumns = @JoinColumn(name = "order_id"),
         inverseJoinColumns = @JoinColumn(name = "product_order_id"))
 private Set<Category> product_order = new HashSet<>();
}
