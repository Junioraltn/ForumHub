package com.forum.ForumHub.domain.topicos.dto;

import com.forum.ForumHub.domain.topicos.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopico(

        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotBlank(message = "Mensagem é obrigatório")
        String mensagem,
        @NotNull
        Status status,
        @NotNull
        @Valid
        String curso,
        @NotNull
        Long idAutor,
        String resposta
) {
}
