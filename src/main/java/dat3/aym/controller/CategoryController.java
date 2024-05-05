package dat3.aym.controller;

import dat3.aym.dto.CategoryDto;
import dat3.aym.dto.ColorDto;
import dat3.aym.entity.Category;
import dat3.aym.entity.Color;
import dat3.aym.service.CategoryService;
import dat3.aym.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //Get all categories
    @GetMapping("")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //Get category based on id
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    //Post category to database
    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    //Update category in database
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    //Delete category in database
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "Category with ID: " + id + " has been deleted";
    }
}
