package br.com.gestao_obras.dto.request.crm_vendas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String nome;

    private ContatoRequestDTO contatoes;

    @NotNull(message = "O tipo de cliente é obrigatório.")
    private TipoCliente tipoCliente;

    @NotNull(message = "O status do CRM é obrigatório.")
    private StatusCRM status;

    private List<UUID> propostasComerciaisIds;

    private List<UUID> projetosIds;

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
