package com.forum.ForumHub.domain.topicos.Respostas;

import com.forum.ForumHub.domain.autores.Autores;
import com.forum.ForumHub.domain.topicos.Topicos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respostas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private Boolean solucao;

    @ManyToOne
    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    private Autores autor;

    @ManyToOne
    @JoinColumn(name = "id_topico", referencedColumnName = "id")
    private Topicos topico;

}
