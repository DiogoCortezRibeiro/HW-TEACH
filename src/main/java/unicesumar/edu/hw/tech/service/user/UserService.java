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

    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.size() > 0) {
            return new ResponseEntity(users, HttpStatus.OK);
        }

        return new ResponseEntity("Nenhum usuario cadastrado", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity saveUser(User user) {
        User userCreated = userRepository.save(user);
        if (userCreated != null) {
            return new ResponseEntity(userCreated, HttpStatus.CREATED);
        }

        return new ResponseEntity("Erro ao tentar cadastrar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity updateUser(User user) {
        Integer successFullyChanged = userRepository.updateUser(user.getEmail(), user.getPassword(), user.getId());
        if (successFullyChanged > 0) {
            return new ResponseEntity(user, HttpStatus.OK);
        }

        return new ResponseEntity("Erro ao atualizar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity deleteById(Long id) {
        Integer successFullyDeleted = userRepository.deleteUser(id);
        if (successFullyDeleted > 0) {
            return new ResponseEntity("Usário excluido com sucesso!", HttpStatus.OK);
        }

        return new ResponseEntity("Erro ao deletar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity validateLogin(String email, String password) {
        User user = userRepository.getUserByEmailAndPassword(email, password);
        if( user != null) {
            return new ResponseEntity("Login realizado com sucesso!", HttpStatus.OK);
        }

        return new ResponseEntity("E-mail ou senha inválidos", HttpStatus.BAD_REQUEST);
    }
}
