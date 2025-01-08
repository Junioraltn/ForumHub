package com.forum.ForumHub.repository;

import com.forum.ForumHub.domain.cursos.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursosRepository extends JpaRepository<Cursos,Long> {

    boolean existsByNome(String nome);

    @Query("""
            SELECT c
                FROM Curso c
                    WHERE c.nome =:nome
            """)
    Cursos getReferenceByNome(String nome);

    @Query("""
            SELECT c
                FROM Curso c
                    WHERE c.nome ILIKE :nome
            """)
    Optional<Cursos> OptGetReferenceByNome(String nome);
}
