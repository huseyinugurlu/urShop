package com.shop.urshop.controller.product;

import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.product.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.PRODUCTS)
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllProductsResponse> getAll() {
    return GetAllProductsResponse.fromProducts(productService.getAll());
  }

  @GetMapping(ApiConstants.GET_BY_CATEGORY_ID + ApiConstants.BY_ID)
  public List<GetAllProductsResponse> getByCategoryId(@PathVariable int id) {
    return GetAllProductsResponse.fromProducts(productService.getByCategory(id));
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdProductResponse getByIdProductResponse(@PathVariable int id) {
    return GetByIdProductResponse.fromProduct(productService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreateProductRequest createProductRequest) {
    this.productService.add(
        createProductRequest.name(),
        createProductRequest.price(),
        createProductRequest.stock(),
        createProductRequest.description(),
        createProductRequest.categoryId());
  }

  @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
  public void update(@PathVariable int id, @RequestBody UpdateProductRequest updateProductRequest) {
    this.productService.update(
        id,
        updateProductRequest.name(),
        updateProductRequest.price(),
        updateProductRequest.stock(),
        updateProductRequest.description(),
        updateProductRequest.categoryId());
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.productService.delete(id);
  }
}
