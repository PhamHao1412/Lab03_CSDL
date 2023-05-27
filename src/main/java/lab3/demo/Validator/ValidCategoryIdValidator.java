package lab3.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import lab3.demo.entity.Category;
import lab3.demo.Validator.annotation.ValidCategoryId;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }
}