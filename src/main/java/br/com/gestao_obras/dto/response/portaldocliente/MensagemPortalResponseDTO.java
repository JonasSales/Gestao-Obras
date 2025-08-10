package br.com.gestao_obras.dto.response.portaldocliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemPortalResponseDTO {

    private UUID id;

    private String assunto;

    private String corpo;

    private UUID remetenteUserId;

    private UUID remetenteClienteId;

    private UUID destinatarioUserId;

    private UUID destinatarioClienteId;

    private UUID projetoId;

    private LocalDateTime dataEnvio;

    private String statusMensagem;

    private String mensagem;
}
