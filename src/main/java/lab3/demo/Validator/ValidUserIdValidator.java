package lab3.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lab3.demo.entity.Category;
import lab3.demo.entity.User;
import lab3.demo.Validator.annotation.ValidCategoryId;
import lab3.demo.Validator.annotation.ValidUserId;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}