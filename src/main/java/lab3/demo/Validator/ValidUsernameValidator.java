package lab3.demo.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lab3.demo.repository.IUserRepository;
import lab3.demo.Validator.annotation.ValidUserName;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUserName, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}