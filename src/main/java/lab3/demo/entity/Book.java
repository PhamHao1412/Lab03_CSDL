package lab3.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lab3.demo.Validator.annotation.ValidCategoryId;
import lab3.demo.Validator.annotation.ValidUserId;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", length = 50)
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, message = "Title must be less than 50 character")
    private String title;

    @Column(name = "author", length = 50)
    @NotEmpty(message = "Author must not be null")
    @Size(max = 50, message = "Author must be less than 50 characters")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ValidCategoryId(message = "Please choose category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
