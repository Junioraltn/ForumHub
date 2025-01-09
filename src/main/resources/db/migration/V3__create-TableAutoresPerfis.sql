CREATE TABLE AutorPerfil(
    id_Autor INT NOT NULL,
    id_Perfil INT NOT NULL,
    CONSTRAINT fk_AutorPerfil_autor FOREIGN KEY (id_Autor) REFERENCES Autores(id),
    CONSTRAINT fk_AutorPerfil_perfil FOREIGN KEY (id_Perfil) REFERENCES Perfis(id)
);