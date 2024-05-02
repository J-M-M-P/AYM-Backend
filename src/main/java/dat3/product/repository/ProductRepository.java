package dat3.product.repository;

import dat3.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // add custom queries, to search for specific products, if needed
}
