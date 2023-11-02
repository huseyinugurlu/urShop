package com.shop.urshop.controller.category;

import com.shop.urshop.category.*;
import com.shop.urshop.controller.ApiConstants;
import com.shop.urshop.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_URL + ApiConstants.CATEGORIES)
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping(ApiConstants.GET_ALL)
  public List<GetAllCategoryResponse> getAll() {
    return GetAllCategoryResponse.fromCategories(categoryService.getAll());
  }

  @GetMapping(ApiConstants.BY_ID)
  public GetByIdCategoryResponse getByIdCategoryResponse(@PathVariable int id) {
    return GetByIdCategoryResponse.fromCategory(categoryService.getById(id));
  }

  @PostMapping(ApiConstants.ADD)
  public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
    this.categoryService.add(Category.builder().name(createCategoryRequest.name()).build());
  }

  @PutMapping(ApiConstants.UPDATE + ApiConstants.BY_ID)
  public void update(
      @PathVariable int id, @RequestBody final UpdateCategoryRequest updateCategoryRequest) {
    this.categoryService.update(
        Category.builder().id(id).name(updateCategoryRequest.name()).build());
  }

  @DeleteMapping(ApiConstants.BY_ID)
  public void delete(@PathVariable int id) {
    this.categoryService.delete(id);
  }
}
