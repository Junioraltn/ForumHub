package com.forum.ForumHub.domain.topicos;

import com.forum.ForumHub.domain.autores.Autores;
import com.forum.ForumHub.domain.cursos.Cursos;
import com.forum.ForumHub.domain.topicos.Respostas.Respostas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String mensagemHash;
    private LocalDateTime data_criacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Curso", referencedColumnName = "id")
    private Cursos curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Autor", referencedColumnName = "id") // Define a coluna de chave estrangeira
    private Autores autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respostas> respostas = new ArrayList<>();

    public void atualizarInformacoes(String titulo,String mensagem,Cursos curso) {

        if (titulo != null){
            this.titulo = titulo;
        }
        if (mensagem != null){
            this.mensagem = mensagem;
        }
        if (curso != null){
            this.curso = curso;
        }

    }
}
