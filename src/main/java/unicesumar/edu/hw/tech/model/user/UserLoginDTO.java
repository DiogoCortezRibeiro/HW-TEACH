package unicesumar.edu.hw.tech.model.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginDTO {

    @NotNull(message = "Parâmetro [E-mail] deve ser informado")
    private String email;

    @NotNull(message = "Parâmetro [Password] deve ser informado")
    private String password;
}
