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
@Table(name = "order_entity")
public class Order {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int orderId;

 private LocalDateTime created;
 private boolean isShipped;

// @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
// private Set<OrderLine> orderLineSet = new HashSet<>();

 @ManyToOne
 @JoinColumn(name = "username", nullable = false)
 private UserWithRoles user;

}
