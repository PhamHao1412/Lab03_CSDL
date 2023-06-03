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
    public String showAllCategories(Model model){
        List<Category> categories    = categoryServices.getAllCategories();
        model.addAttribute("categories",categories);
        return "Category/list";
    }
    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "Category/add";
    }
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "Category/add";
        }
        categoryServices.saveCategory(category);
        return "redirect:/categories/list";
    }
    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryServices.getCategoryById(id);
        model.addAttribute("category", category);

        return "Category/edit";
    }
    @PostMapping("/edit/{id}")
    public String editCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "Category/edit";
        }
        categoryServices.saveCategory(category);
        return "redirect:/categories/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryServices.deleteCategory(id);
        return "redirect:/categories/list    ";
    }
}
