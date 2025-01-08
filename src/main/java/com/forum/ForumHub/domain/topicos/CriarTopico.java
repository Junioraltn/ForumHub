package com.forum.ForumHub.domain.topicos;

import com.forum.ForumHub.domain.ValidationException;
import com.forum.ForumHub.domain.cursos.Cursos;
import com.forum.ForumHub.domain.cursos.CursosEnum;
import com.forum.ForumHub.domain.topicos.dto.DadosTopico;
import com.forum.ForumHub.domain.topicos.dto.DadosTopicoDetalhado;
import com.forum.ForumHub.domain.topicos.validacoes.ValidacaoTopico;
import com.forum.ForumHub.infra.security.SecurityGeral;
import com.forum.ForumHub.repository.AutoresRepository;
import com.forum.ForumHub.repository.CursosRepository;
import com.forum.ForumHub.repository.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CriarTopico {
    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private AutoresRepository autoresRepository;
    @Autowired
    private CursosRepository cursosRepository;
    @Autowired
    private List<ValidacaoTopico> validadores;

    public DadosTopicoDetalhado criarTopico(@Valid DadosTopico dados) throws NoSuchAlgorithmException {

        //Checar se o autor ou curso (Id) existe no repositório
        if (!autoresRepository.existsById(dados.idAutor())) {
            throw new ValidationException("Id do autor não existe");
        }
        Optional<Cursos> curso = cursosRepository.OptGetReferenceByNome(CursosEnum.fromString(dados.curso()).toString());

        if (curso.isEmpty()) {
            throw new ValidationException("Id do curso não existe");
        }

        //Usando a dependência java-jwt para gerar um hash 256 da mensagem
        var mensagem_hash = SecurityGeral.calculateSHA256(dados.mensagem());

        //Injetando os validadores
        validadores.forEach(v -> v.validar(dados,mensagem_hash));

        var autor = autoresRepository.getReferenceById(dados.idAutor());

        var topico = new Topicos(null, dados.titulo(), dados.mensagem(), mensagem_hash, LocalDateTime.now(), Status.ABERTA, curso.get(), autor, null);
        topicosRepository.save(topico);
        return new DadosTopicoDetalhado(topico);
    }
}