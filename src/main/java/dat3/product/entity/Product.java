package dat3.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String image;
    private int qty; // ændret amount fra ER-dia til qty(quantity)
    private boolean onSale;
    private double discountPrice;

    // Foreign key CATEGORY
//    @OneToMany(mappedBy = "products")
//    private Set<JewelCategory> jewelCategory;
//
//    // Foreign key relation til COLOR
//    @OneToMany(mappedBy = "products")
//    private Set<Color> color;
//
//    // Foreign key relation til MATERIAL
//    @OneToMany(mappedBy = "products")
//    private Set<Material> material;
//
//    // Many to many relation til order entitet
//    @ManyToMany(mappedBy = "orders")
//    private Set<Order> order;


    public String toString() {
        return "Product{" +
                "Id: " + id +
                ", name: " + name + '\'' +
                ", price: " + price +
                ", image: " + image + '\'' +
                ", qty: " + qty +
                ", onSale: " + onSale +
                ", discountPrice: " + discountPrice +
                "}";
    }
}
