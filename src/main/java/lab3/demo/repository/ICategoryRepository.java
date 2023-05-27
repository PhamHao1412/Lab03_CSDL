package lab3.demo.repository;

import lab3.demo.entity.Book;
import lab3.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {


}
