package lab3.demo.repository;

import lab3.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
