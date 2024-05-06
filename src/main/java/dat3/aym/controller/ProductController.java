package dat3.aym.controller;

import dat3.aym.dto.ProductDto;
import dat3.aym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
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
