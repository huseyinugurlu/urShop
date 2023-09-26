package com.shop.urshop.category;

import com.shop.urshop.entity.Category;
import com.shop.urshop.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new BusinessException("Category not found!"));

    }

    @Override
    public void add(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        if (categoryRepository.existsById(category.getCategoryId())) {
            this.categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found!");
        }

    }

    @Override
    public void delete(int categoryId) {

        if (categoryRepository.existsById(categoryId)) {
            this.categoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Category not found!");
        }
    }

}
