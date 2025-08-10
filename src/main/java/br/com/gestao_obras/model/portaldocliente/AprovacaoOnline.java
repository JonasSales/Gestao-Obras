package br.com.gestao_obras.model.portaldocliente;

import br.com.gestao_obras.model.autenticacaoeusuarios.User;
import br.com.gestao_obras.model.crm_vendas.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AprovacaoOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String descricao;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataResposta;

    @Enumerated(EnumType.STRING)
    private StatusAprovado statusAprovado;

    @Enumerated(EnumType.STRING)
    private TipoObjetoAprovacao tipoObjetoAprovacao;

    @Column(nullable = false)
    private UUID idObjetoAprovado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private User solicitante;

    public enum StatusAprovado {
        PENDENTE,
        APROVADO,
        REJEITADO
    }

    public enum TipoObjetoAprovacao {
        PROPOSTA_COMERCIAL,
        REVISAO_PROJETO,
        ETAPA_ORCAMENTO
    }
}