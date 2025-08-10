package br.com.gestao_obras.dto.response.gestaodeprojetos;

import br.com.gestao_obras.dto.response.executaodeobras.ObraResponseDTO;
import br.com.gestao_obras.dto.response.orcamentacaoecustos.OrcamentoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoResponseDTO {

    private UUID id;

    private String nome;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private StatusProjeto statusProjeto;

    private UUID gerenteProjetoId;

    private UUID clienteId;

    private List<MarcoProjetoResponseDTO> marcos;

    private List<RevisaoProjetoResponseDTO> revisoes;

    private List<TarefaResponseDTO> tarefas;

    private OrcamentoResponseDTO orcamento;

    private ObraResponseDTO obra;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    private String statusMensagem;

    private String mensagem;

    public enum StatusProjeto {
        PLANEJAMENTO,
        EM_EXECUCAO,
        CONCLUIDO,
        CANCELADO
    }
}
