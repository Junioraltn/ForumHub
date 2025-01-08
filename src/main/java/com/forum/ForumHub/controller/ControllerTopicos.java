package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.ValidationException;
import com.forum.ForumHub.domain.cursos.CursosEnum;
import com.forum.ForumHub.domain.topicos.CriarTopico;
import com.forum.ForumHub.domain.topicos.Topicos;
import com.forum.ForumHub.domain.topicos.dto.DadosAtualizacaoTopico;
import com.forum.ForumHub.domain.topicos.dto.DadosTopico;
import com.forum.ForumHub.domain.topicos.dto.DadosTopicoDetalhado;
import com.forum.ForumHub.repository.CursosRepository;
import com.forum.ForumHub.repository.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class ControllerTopicos {

    @Autowired
    private CriarTopico criarTopico;
    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private CursosRepository cursosRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insercao(@RequestBody @Valid DadosTopico dados) throws NoSuchAlgorithmException {

        var dto = criarTopico.criarTopico(dados);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosTopicoDetalhado>> listar(@PageableDefault(size=10,sort={"titulo"}) Pageable paginacao){
        var page = topicosRepository.findAll(paginacao).map(DadosTopicoDetalhado::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        Optional<Topicos> topico = topicosRepository.OptgetReferenceById(dados.id());
        if (topico.isPresent()){
            var id_curso = cursosRepository.getReferenceByNome(CursosEnum.fromString(dados.curso()).toString());
            topico.get().atualizarInformacoes(dados.titulo(),dados.mensagem(),id_curso);
            return ResponseEntity.ok(new DadosTopicoDetalhado(topico.get()));
        }else{
            throw new ValidationException("Tópico Inválido");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = topicosRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosTopicoDetalhado(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
       topicosRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}