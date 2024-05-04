package dat3.product.service;

import dat3.product.dto.ProductDto;
import dat3.product.entity.Product;
import dat3.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //GET ALL
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productResponses = products.stream().map((p) -> new ProductDto(p)).toList();
        return productResponses;
    }

    //GET ID
    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return new ProductDto(product);
    }

    // UPDATE
    public ProductDto updateProduct(int id, ProductDto request) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id does not match(you cannot change the id)");
        }

        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        editProduct(productToUpdate, request);

//        Product updatedProduct = productRepository.save(productToUpdate);
        productRepository.save(productToUpdate);
        return new ProductDto(productToUpdate);
    }

    public void editProduct(Product original, ProductDto p) {
        original.setName(p.getName());
        original.setPrice(p.getPrice());
        original.setImage(p.getImage());
        original.setQty(p.getQty());
        original.setOnSale(p.isOnSale());
        original.setDiscountPrice(p.getDiscountPrice());
    }

    // CREATE
    public void createProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    // DELETE
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}