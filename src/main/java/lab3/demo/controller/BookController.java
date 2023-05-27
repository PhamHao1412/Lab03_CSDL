package lab3.demo.controller;

import jakarta.validation.Valid;
import lab3.demo.entity.Book;
import lab3.demo.services.BookService;
import lab3.demo.services.CategoryService;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryServices;


    @GetMapping("/list")
    public String showAllCategories(Model model){
        List<Book> books    = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "Book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryServices.getAllCategories());
        return "Book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryServices.getAllCategories());
            return "Book/add";
        }
        bookService.addBook(book);
        return "redirect:/books/list";
    }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        // Get the book by ID
        Book book = bookService.getBookById(id);

        // Add the book and categories to the model
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryServices.getAllCategories());

        return "Book/edit";
    }

    // POST request to handle the form submission
    @PostMapping("/edit/{id}")
    public String editBook(@ModelAttribute("book") Book book) {
        Long id = book.getId();

        bookService.updateBook(book);

        return "redirect:/books/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/books/list    ";
    }


}
