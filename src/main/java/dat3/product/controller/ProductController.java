package dat3.product.controller;

import dat3.product.dto.ProductDto;
import dat3.product.entity.Product;
import dat3.product.repository.ProductRepository;
import dat3.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //GET ALL
    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    //GET ID
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // POST
    @PostMapping()
    public ProductDto createProduct(@RequestBody ProductDto request) {
        return productService.createProduct(request);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestBody ProductDto request) {
        return productService.updateProduct(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
