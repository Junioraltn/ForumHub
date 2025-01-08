CREATE TABLE Topicos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    mensagem_hash VARCHAR(64) NOT NULL,
    data_criacao DATETIME NOT NULL,
    status ENUM('ABERTA','RESPONDIDA','FECHADA','RESOLVIDA','AGUARDANDO_RESPOSTA') NOT NULL DEFAULT 'ABERTA',
    id_Autor INT NOT NULL,
    id_Curso INT NOT NULL,
    respostas TEXT,

    FULLTEXT INDEX idx_mensagem_fulltext (mensagem),
    CONSTRAINT unicoTitulo UNIQUE (titulo,mensagem_hash),
    CONSTRAINT fk_topicos_autor FOREIGN KEY (id_Autor) REFERENCES Autores(id),
    CONSTRAINT fk_topicos_curso FOREIGN KEY (id_Curso) REFERENCES Cursos(id)
);