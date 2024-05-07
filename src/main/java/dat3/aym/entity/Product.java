package dat3.aym.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String image;
    private int qty;
    private boolean onSale;
    private double discountPrice;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_color",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_material",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private Set<Material> materials = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes = new HashSet<>();

//    // Foreign key relation til MATERIAL
//    @OneToMany(mappedBy = "products")
//    private Set<Material> material;
//
//    // many to many relation til size entitet
//    @ManyToMany(mappedBy = "size")
//    private Set<Size> size;
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
