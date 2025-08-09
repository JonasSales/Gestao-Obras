package br.com.gestao_obras.model.PortalDoCliente;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import br.com.gestao_obras.model.crm_vendas.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Importação correta
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

    private LocalDateTime dataSolicitacao; // Tipo corrigido

    private LocalDateTime dataResposta; // Nome e tipo corrigidos

    @Enumerated(EnumType.STRING)
    private StatusAprovado statusAprovado;

    @Enumerated(EnumType.STRING)
    private TipoObjetoAprovacao tipoObjetoAprovacao; // Nome do enum mais genérico

    // Armazena o ID do objeto que está sendo aprovado (seja uma Proposta, Revisão, etc.)
    @Column(nullable = false)
    private UUID idObjetoAprovado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private User solicitante; // Nome mais claro

    public enum StatusAprovado {
        PENDENTE,
        APROVADO,
        REJEITADO
    }

    public enum TipoObjetoAprovacao { // Nome do enum corrigido
        PROPOSTA_COMERCIAL,
        REVISAO_PROJETO,
        ETAPA_ORCAMENTO // Exemplo adicional
    }
}