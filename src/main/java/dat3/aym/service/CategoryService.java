package dat3.aym.service;

import dat3.aym.dto.CategoryDto;
import dat3.aym.entity.Category;
import dat3.aym.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Get all categories
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            categoryDtoList.add(new CategoryDto(category));
        }

        return categoryDtoList;
    }

    //Get category by id
    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
        return new CategoryDto(category);
    }

    //Create category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    //Delete category
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    //Update category
    public Category updateCategory(int categoryId, Category updatedCategory) {
        // Check if color with that ID exists in database
        Optional<Category> existingCategoryOptional = categoryRepository.findById(categoryId);

        if (existingCategoryOptional.isPresent()) {
            // If color exists, update the rest of the properties
            Category existingCategory = existingCategoryOptional.get();
            existingCategory.setName(updatedCategory.getName());

            // Save updated color in database
            return categoryRepository.save(existingCategory);
        } else {
            // If color does not exist in database, throw error
            throw new RuntimeException("Category with ID: " + categoryId + " not found");
        }
    }

}
