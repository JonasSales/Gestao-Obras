package br.com.gestao_obras.model.GestaoDeProjetos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroTempoTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id")
    @JsonIgnore
    private Tarefa tarefa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User usuarioQueRegistrouTempo;

    @Transient
    public long getDuracaoEmMinutos() {
        if (inicio == null || fim == null) {
            return 0;
        }
        return Duration.between(inicio, fim).toMinutes();
    }
}