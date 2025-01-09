package com.forum.ForumHub.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.forum.ForumHub.domain.autores.Autores;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${forumhub.security.token.secret}")
    private String secret;
    private static final String ISSUER = "API ForumHub";

    public String gerarToken(Autores autores){
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(autores.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token JWT",exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenLWT){
        try {
            var algoritimo = Algorithm.HMAC256(secret);

            System.out.println(secret);

            return JWT.require(algoritimo)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenLWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT invalido ou expirado");
        }
    }
}