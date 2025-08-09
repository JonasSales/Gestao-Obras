package br.com.gestao_obras.model.ExecucaoDeObras;

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
public class FotoDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // O caminho (URL) para o arquivo da imagem.
    // Pode ser um link para um serviço de armazenamento como Amazon S3, Google Cloud Storage, etc.
    @Column(nullable = false)
    private String urlArquivo;

    // Uma legenda ou descrição opcional para a foto.
    private String legenda;

    // A data e hora em que a foto foi registrada no sistema.
    // @CreationTimestamp preenche este campo automaticamente na primeira vez que o objeto é salvo.
    @CreationTimestamp
    @Column(updatable = false) // Garante que a data de criação não seja alterada depois.
    private LocalDateTime dataUpload;

    // O relacionamento que liga esta foto de volta ao seu respectivo diário de obra.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diario_obra_id")
    @JsonIgnore // Essencial para evitar loops infinitos ao converter para JSON.
    private DiarioObra diarioObra;

}