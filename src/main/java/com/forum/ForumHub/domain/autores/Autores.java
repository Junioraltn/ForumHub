package com.forum.ForumHub.domain.autores;


import com.forum.ForumHub.domain.perfis.Perfis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @OneToOne
    @JoinColumn(name = "id_perfil", referencedColumnName = "id")
    private Perfis perfil;


}
