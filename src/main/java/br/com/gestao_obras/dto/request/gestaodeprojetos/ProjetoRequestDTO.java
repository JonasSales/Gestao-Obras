package br.com.gestao_obras.dto.request.gestaodeprojetos;

import br.com.gestao_obras.dto.request.executaodeobras.ObraRequestDTO;
import br.com.gestao_obras.dto.request.orcamentacaoecustos.OrcamentoRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoRequestDTO {

    private UUID id;

    @NotBlank(message = "O nome do projeto é obrigatório.")
    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @NotNull(message = "O status do projeto é obrigatório.")
    private StatusProjeto statusProjeto;

    @NotNull(message = "O ID do gerente do projeto é obrigatório.")
    private UUID gerenteProjetoId;

    @NotNull(message = "O ID do cliente é obrigatório.")
    private UUID clienteId;

    private List<MarcoProjetoRequestDTO> marcos;

    private List<RevisaoProjetoRequestDTO> revisoes;

    private List<TarefaRequestDTO> tarefas;

    private OrcamentoRequestDTO orcamento;

    private ObraRequestDTO obra;

    public enum StatusProjeto {
        PLANEJAMENTO,
        EM_EXECUCAO,
        CONCLUIDO,
        CANCELADO
    }
}
