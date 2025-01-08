package com.forum.ForumHub.domain.topicos.validacoes;

import com.forum.ForumHub.domain.topicos.dto.DadosTopico;

public interface ValidacaoTopico {
    void validar(DadosTopico dados,String mensagem_hash);
}
