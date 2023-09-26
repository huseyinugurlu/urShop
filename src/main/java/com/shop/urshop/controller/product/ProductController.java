package com.shop.urshop.controller.product;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.entity.Product;
import com.shop.urshop.product.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController extends BaseController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllProductsResponse> data=GetAllProductsResponse.fromProducts(productService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdProductResponse(@PathVariable int id) {
        final GetByIdProductResponse data=GetByIdProductResponse.fromProduct(productService.getById(id));
        return success(data);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        Product product=Product.builder()
                .productName(createProductRequest.name())
                .price(createProductRequest.price())
                .description(createProductRequest.description())
                .stock(createProductRequest.stock())
                .category(createProductRequest.category())
                .build();
        this.productService.add(product);
    }

    @PutMapping("/{productId}")
    public void update(@RequestBody UpdateProductRequest updateProductRequest) {
        Product product=Product.builder()
                .productId(updateProductRequest.id())
                .productName(updateProductRequest.name())
                .price(updateProductRequest.price())
                .description(updateProductRequest.description())
                .stock(updateProductRequest.stock())
                .category(updateProductRequest.category())
                .build();
        this.productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }

}
