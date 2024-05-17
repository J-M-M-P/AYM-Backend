package dat3.aym.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.aym.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Removes all properties with null values
public class ProductDto {
    private Integer id;
    private String name;
    private double price;
    private String image;
    private int qty;
    private boolean onSale;
    private double discountPrice;
    private Set<Category> categories;
    private Set<Color> colors;
    private Set<Material> materials;
    private Set<Size> sizes;

    public ProductDto(Product p) {
        this.id = p.getProductId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.image = p.getImage();
        this.qty = p.getQty();
        this.onSale = p.isOnSale();
        this.discountPrice = p.getDiscountPrice();
        this.categories = p.getCategories();
        this.colors = p.getColors();
        this.materials = p.getMaterials();
        this.sizes = p.getSizes();
    }
}
