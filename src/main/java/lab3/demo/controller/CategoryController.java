package lab3.demo.controller;
import java.util.List;

import jakarta.validation.Valid;
import lab3.demo.entity.Category;
import lab3.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/categories")

public class CategoryController {

    @Autowired
    private CategoryService categoryServices;
    @GetMapping("/list")
    public String showAllBooks(Model model){
        List<Category> categories    = categoryServices.getAllCategories();
        model.addAttribute("categories",categories);
        return "Category/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("category", new Category());
        return "Category/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("category", categoryServices.getAllCategories());
            return "Categories/add";
        }
        categoryServices.saveCategory(category);
        return "redirect:/categories/list";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        // Get the book by ID
        Category category = categoryServices.getCategoryById(id);

        // Add the book and categories to the model
        model.addAttribute("categories", category);

        return "Category/edit";
    }

    // POST request to handle the form submission
    @PostMapping("/edit/{id}")
    public String editBook(@ModelAttribute("") Category category) {
        Long id = category.getId();

        categoryServices.saveCategory(category);

        return "redirect:/categories/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        categoryServices.deleteCategory(id);
        return "redirect:/categories/list    ";
    }
}
