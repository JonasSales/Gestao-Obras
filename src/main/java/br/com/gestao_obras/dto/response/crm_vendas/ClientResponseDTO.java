package br.com.gestao_obras.dto.response.crm_vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

    private UUID id;

    private String nome;

    private List<ContatoResponseDTO> contatoes;

    private TipoCliente tipoCliente;

    private StatusCRM status;

    private List<UUID> propostasComerciaisIds;

    private List<UUID> projetosIds;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String mensagem;

    public enum TipoCliente {
        LEAD,
        PROSPECT,
        CLIENTE
    }

    public enum StatusCRM {
        NOVO,
        NEGOCIACAO,
        ATIVO
    }
}
