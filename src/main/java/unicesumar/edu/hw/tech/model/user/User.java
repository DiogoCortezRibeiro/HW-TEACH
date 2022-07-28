package unicesumar.edu.hw.tech.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String email;

    public User() {}

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

}
