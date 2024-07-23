package org.tmo.taskmanagersystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tmo.taskmanagersystem.model.Category;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCreateCategory() {
        // Create a category
        Category category = new Category();
        category.setType("Work");

        // Save the category
        Category createdCategory = categoryService.createCategory(category);

        // Verify the category was created
        assertNotNull(createdCategory.getCategoryID());
        assertEquals("Work", createdCategory.getType());
    }

    @Test
    public void testGetCategoryById() {
        // Create a category
        Category category = new Category();
        category.setType("Work");

        // Save the category
        Category createdCategory = categoryService.createCategory(category);

        // Fetch the category by ID
        Category fetchedCategory = categoryService.getCategoryById(createdCategory.getCategoryID());

        // Verify the category was fetched
        assertNotNull(fetchedCategory);
        assertEquals(createdCategory.getCategoryID(), fetchedCategory.getCategoryID());
    }

    @Test
    public void testUpdateCategory() {
        // Create a category
        Category category = new Category();
        category.setType("Work");

        // Save the category
        Category createdCategory = categoryService.createCategory(category);

        // Update the category
        createdCategory.setType("Personal");
        Category updatedCategory = categoryService.updateCategory(createdCategory.getCategoryID(), createdCategory);

        // Verify the category was updated
        assertNotNull(updatedCategory);
        assertEquals("Personal", updatedCategory.getType());
    }

    @Test
    public void testDeleteCategory() {
        // Create a category
        Category category = new Category();
        category.setType("Work");

        // Save the category
        Category createdCategory = categoryService.createCategory(category);

        // Delete the category
        categoryService.deleteCategory(createdCategory.getCategoryID());

        // Verify the category was deleted
        Category fetchedCategory = categoryService.getCategoryById(createdCategory.getCategoryID());
        assertNull(fetchedCategory);
    }
}