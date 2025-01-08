package com.forum.ForumHub.domain.topicos.validacoes;

import com.forum.ForumHub.domain.ValidationException;
import com.forum.ForumHub.domain.topicos.dto.DadosTopico;
import com.forum.ForumHub.repository.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoUnico implements ValidacaoTopico{

    @Autowired
    private TopicosRepository topicosRepository;

    @Override
    public void validar(DadosTopico dados,String mensagem_hash) {
        var existe = topicosRepository.existsByTituloAndMensagemHash(dados.titulo(),mensagem_hash);
        if (existe){
            throw new ValidationException("Tópico já existente!");
        }
    }
}
