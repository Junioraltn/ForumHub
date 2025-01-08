package com.forum.ForumHub.repository;

import com.forum.ForumHub.domain.topicos.Topicos;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicosRepository extends JpaRepository<Topicos,Long> {

    boolean existsByTituloAndMensagemHash(String titulo, String mensagemHash);

    @Query("""
            SELECT t
                FROM Topico t
                    WHERE t.id = :id
            """)
    Optional<Topicos> OptgetReferenceById(@NotNull Long id);

}
