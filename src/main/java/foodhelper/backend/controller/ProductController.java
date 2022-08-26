package foodhelper.backend.controller;

import foodhelper.backend.dto.ProductDTO;
import foodhelper.backend.service.NutritionixService;
import foodhelper.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final NutritionixService nutritionixService;

    @Autowired
    public ProductController(ProductService productService, NutritionixService nutritionixService) {
        this.productService = productService;
        this.nutritionixService = nutritionixService;
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        productService.save(productDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
        productService.update(productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/nutritionix/{query}")
    public ResponseEntity<?> fetchProductsFromNutritionix(@PathVariable String query) {
        nutritionixService.fetchProducts(query);
        return ResponseEntity.ok().build();
    }
}
