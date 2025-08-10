package br.com.gestao_obras.dto.request.crm_vendas;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do contato é obrigatório.")
    private String nome;

    @NotBlank(message = "O email do contato é obrigatório.")
    @Email(message = "O email informado não é válido.")
    private String email;

    @NotBlank(message = "O telefone do contato é obrigatório.")
    private String telefone;

    //Pode ser de um Cliente ou Fornecedor, melhorar essa lógica depois
    private UUID clienteId;

    private UUID fornecedorId;
}
