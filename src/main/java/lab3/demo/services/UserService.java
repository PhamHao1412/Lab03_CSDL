package lab3.demo.services;

import lab3.demo.entity.User;
import lab3.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}