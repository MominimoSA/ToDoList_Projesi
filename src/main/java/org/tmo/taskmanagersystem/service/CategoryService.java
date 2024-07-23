package org.tmo.taskmanagersystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmo.taskmanagersystem.model.Category;
import org.tmo.taskmanagersystem.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get category by ID
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    // Create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update an existing category
    public Category updateCategory(Long categoryId, Category categoryDetails) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setType(categoryDetails.getType());
            return categoryRepository.save(category);
        }
        return null;
    }

    // Delete a category
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
