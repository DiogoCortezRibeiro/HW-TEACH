package unicesumar.edu.hw.tech.controller.user;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicesumar.edu.hw.tech.model.user.User;
import unicesumar.edu.hw.tech.model.user.UserLoginDTO;
import unicesumar.edu.hw.tech.service.user.UserService;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll() {
        List<User> users =  userService.getAllUsers();
        return users.size() > 0 ? new ResponseEntity(users, HttpStatus.OK) : new ResponseEntity("Nenhum usuario cadastrado", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity register(@RequestBody User user) {
        User userCreated = userService.saveUser(user);
        return userCreated != null ? new ResponseEntity(userCreated, HttpStatus.CREATED) : new ResponseEntity("Erro ao tentar cadastrar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody User user) {
        return userService.updateUser(user) > 0 ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity("Erro ao atualizar usuario", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return userService.deleteById(id) > 0 ? new ResponseEntity("Usário excluido com sucesso!", HttpStatus.OK) : new ResponseEntity("Erro ao deletar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity login(@NotNull @RequestBody UserLoginDTO user) {
        return userService.validateLogin(user.getEmail(), user.getPassword());
    }
}
