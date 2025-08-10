package br.com.gestao_obras.dto.request.comprasesuprimento;

import br.com.gestao_obras.dto.request.crm_vendas.ContatoRequestDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestDTO {

    private UUID idFornecedor;

    @NotBlank(message = "O nome do fornecedor é obrigatório.")
    private String nomeFornecedor;

    @NotBlank(message = "O CNPJ do fornecedor é obrigatório.")
    private String cnpjFornecedor;

    private ContatoRequestDTO contatos;
}