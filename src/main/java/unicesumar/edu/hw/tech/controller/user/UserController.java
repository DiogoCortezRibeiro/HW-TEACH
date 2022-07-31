package unicesumar.edu.hw.tech.controller.user;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicesumar.edu.hw.tech.model.user.User;
import unicesumar.edu.hw.tech.model.user.UserLoginDTO;
import unicesumar.edu.hw.tech.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity getAll() {
        return this.userService.getAllUsers();
    }
    @PostMapping
    public ResponseEntity register(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
    @PostMapping("/login")
    public ResponseEntity login(@NotNull @RequestBody UserLoginDTO user) {
        return userService.validateLogin(user.getEmail(), user.getPassword());
    }
}
