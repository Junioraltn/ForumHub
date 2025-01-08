package com.forum.ForumHub.domain.topicos.dto;

import com.forum.ForumHub.domain.topicos.Respostas.Respostas;
import com.forum.ForumHub.domain.topicos.Status;
import com.forum.ForumHub.domain.topicos.Topicos;
import java.time.LocalDateTime;
import java.util.List;

public record DadosTopicoDetalhado (
                                    Long id,
                                    String titulo,
                                    String mensagem,
                                    LocalDateTime dataCriacao,
                                    Status status,
                                    Long curso,
                                    Long autor,
                                    List<Respostas> resposta
                                    ) {
    public DadosTopicoDetalhado(Topicos topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                topico.getCurso().getId(),
                topico.getAutor().getId(),
                topico.getRespostas());
    }
}
