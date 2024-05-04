package dat3.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // fjerner null values fra dto'ens json data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private String image;
    private int qty;
    private boolean onSale;
    private double discountPrice;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.image = p.getImage();
        this.qty = p.getQty();
        this.onSale = p.isOnSale();
        this.discountPrice = p.getDiscountPrice();
    }
}
