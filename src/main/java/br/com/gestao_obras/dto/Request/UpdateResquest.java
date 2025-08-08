package br.com.gestao_obras.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResquest {

    @NotBlank(message = "O primeiro nome não pode ser nulo")
    private String firstName;
    @NotBlank(message = "O sobrenome nome não pode ser nulo")
    private String lastName;

}
