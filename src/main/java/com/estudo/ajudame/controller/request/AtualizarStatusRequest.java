package com.estudo.ajudame.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record AtualizarStatusRequest(
        @Schema(description = "Status da ponto de coleta. Valores aceitos: ABERTO, FECHADO"
        ,example = "ABERTO"
                , requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "O status deve ser informado")
        String status
) {
}
