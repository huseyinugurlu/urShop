package com.shop.urshop.controller.category;


import com.shop.urshop.category.*;
import com.shop.urshop.controller.BaseController;
import com.shop.urshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllCategoryResponse> data=GetAllCategoryResponse.fromCategories(categoryService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdCategoryResponse(@PathVariable int id) {
        final GetByIdCategoryResponse data = GetByIdCategoryResponse.fromCategory(categoryService.getById(id));
        return success(data);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        final Category category= Category.builder()
                .categoryName(createCategoryRequest.name())
                .build();
        this.categoryService.add(category);
    }

    @PutMapping("/update")
    public void update(@RequestBody final UpdateCategoryRequest updateCategoryRequest) {
        Category category= Category.builder()
                .categoryId(updateCategoryRequest.id())
                .categoryName(updateCategoryRequest.name())
                .build();
        this.categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }


}
