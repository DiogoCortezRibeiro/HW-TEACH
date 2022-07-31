package unicesumar.edu.hw.tech.model.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Parâmetro [Password] deve ser informado")
    private String password;
    @NotNull(message = "Parâmetro [E-mail] deve ser informado")
    private String email;

    public User() {}
    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

}
