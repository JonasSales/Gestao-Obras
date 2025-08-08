package br.com.gestao_obras.dto.Response;

import br.com.gestao_obras.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserRegisterResponse {
    private String firstName;
    private String lastName;
    private String email;

    public  UserRegisterResponse(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}
