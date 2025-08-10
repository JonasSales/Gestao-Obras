package br.com.gestao_obras.dto.response.comprasesuprimento;

import br.com.gestao_obras.dto.response.crm_vendas.ContatoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorResponseDTO {

    private UUID idFornecedor;

    private String nomeFornecedor;

    private String cnpjFornecedor;

    private ContatoResponseDTO contatos;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String status;

    private String mensagem;
}
