package lab3.demo.services;

import lab3.demo.entity.Book;
import lab3.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(long id){
        return bookRepository.findById(id).orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }
}
