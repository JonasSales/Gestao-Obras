package br.com.gestao_obras.dto.request.portaldocliente;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemPortalRequestDTO {

    private UUID id;

    @NotBlank(message = "O assunto é obrigatório.")
    private String assunto;

    @NotBlank(message = "O corpo da mensagem é obrigatório.")
    private String corpo;

    private UUID remetenteUserId;

    private UUID remetenteClienteId;

    private UUID destinatarioUserId;

    private UUID destinatarioClienteId;

    private UUID projetoId;
}
