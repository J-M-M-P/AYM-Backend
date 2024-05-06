package dat3.aym.repository;

import dat3.aym.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // add custom queries, to search for specific products, if needed
}
