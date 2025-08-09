package br.com.gestao_obras.model.GestaoDeProjetos;

import br.com.gestao_obras.model.AutenticacaoEUsuarios.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime; // Importação correta
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroTempoTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Guarda a data e hora exata do início do trabalho
    private LocalDateTime inicio;

    // Guarda a data e hora exata do fim do trabalho
    private LocalDateTime fim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id") // Nome da coluna simplificado
    @JsonIgnore
    private Tarefa tarefa;

    // Quem registrou o tempo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User usuarioQueRegistrouTempo;

    /**
     * Calcula a duração em minutos entre o início e o fim.
     * A anotação @Transient impede que este campo seja criado no banco de dados.
     * @return a duração total em minutos.
     */
    @Transient
    public long getDuracaoEmMinutos() {
        if (inicio == null || fim == null) {
            return 0;
        }
        return Duration.between(inicio, fim).toMinutes();
    }
}