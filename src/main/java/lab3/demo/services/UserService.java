package lab3.demo.services;

import lab3.demo.entity.User;
import lab3.demo.repository.IRoleRepository;
import lab3.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public void save(User user){

        userRepository.save(user);
    Long userId = userRepository.getUserIdByUsername(user.getUsername());
    Long roleId = roleRepository.getRoleByName("USER");
    if(roleId!=0&&userId!=0){

        userRepository.addRoleToUser(userId,roleId);
    }
    }

}