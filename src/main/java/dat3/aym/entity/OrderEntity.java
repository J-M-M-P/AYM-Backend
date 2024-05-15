package dat3.aym.entity;

import dat3.security.entity.UserWithRoles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_entity")
public class OrderEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private LocalDateTime created;
 private boolean isShipped;

 @ManyToOne
 @JoinColumn(name = "username")
 private UserWithRoles user;

}
