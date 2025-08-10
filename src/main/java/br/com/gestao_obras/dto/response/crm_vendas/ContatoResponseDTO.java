package br.com.gestao_obras.dto.response.crm_vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoResponseDTO {

    private UUID id;

    private String nome;

    private String email;

    private String telefone;

    private UUID clienteId;

    private UUID fornecedorId;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;
}
