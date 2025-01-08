package com.forum.ForumHub.domain.topicos;

import lombok.Getter;

@Getter
public enum Status {
    ABERTA("Aberto"),
    RESPONDIDA("Respondida"),
    FECHADA("Fechada"),
    RESOLVIDA("Resolvida"),
    AGUARDANDO_RESPOSTA("Aguardando Resposta");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

}
