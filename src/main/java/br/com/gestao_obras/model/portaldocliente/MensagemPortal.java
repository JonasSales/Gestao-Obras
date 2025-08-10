package br.com.gestao_obras.model.portaldocliente;

import br.com.gestao_obras.model.autenticacaoeusuarios.User;
import br.com.gestao_obras.model.gestaodeprojetos.Projeto;
import br.com.gestao_obras.model.crm_vendas.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemPortal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String assunto;

    @Column(columnDefinition = "TEXT")
    private String corpo;

    @CreationTimestamp
    private LocalDateTime dataEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "remetente_user_id")
    @JsonIgnore
    private User remetenteUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "remetente_cliente_id")
    @JsonIgnore
    private Cliente remetenteCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destinatario_user_id")
    @JsonIgnore
    private User destinatarioUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destinatario_cliente_id")
    @JsonIgnore
    private Cliente destinatarioCliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id")
    @JsonIgnore
    private Projeto projeto;
}