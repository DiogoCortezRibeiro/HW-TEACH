package unicesumar.edu.hw.tech.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicesumar.edu.hw.tech.model.user.User;
import unicesumar.edu.hw.tech.repository.user.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Integer updateUser(User user) {
        return userRepository.updateUser(user.getEmail(), user.getPassword(), user.getId());
    }

    public Integer deleteById(Long id) {
        return userRepository.deleteUser(id);
    }

    public ResponseEntity validateLogin(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password) != null ? new ResponseEntity("Login realizado com sucesso!", HttpStatus.OK) : new ResponseEntity("E-mail ou senha inválidos", HttpStatus.BAD_REQUEST);
    }
}
