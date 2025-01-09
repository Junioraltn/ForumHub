package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.autores.Autores;
import com.forum.ForumHub.domain.autores.dto.DadosAutenticacao;
import com.forum.ForumHub.infra.security.TokenService;
import com.forum.ForumHub.infra.security.dto.DadosTokenJWT;
import jakarta.validation.Valid;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login (@RequestBody @Valid DadosAutenticacao dados){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autenticacao = manager.authenticate(autenticacaoToken);
        var tokenJWT = tokenService.gerarToken((Autores) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
