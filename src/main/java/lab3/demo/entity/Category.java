package lab3.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name must not be null")
    @Size(max = 50, message = "name must be less than 50 character")
    private String name;


    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<Book> books;

}
