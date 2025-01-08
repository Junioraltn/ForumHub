CREATE TABLE Respostas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    id_Topico INT NOT NULL,
    solucao BOOLEAN DEFAULT false,
    id_Autor INT NOT NULL,
    data_criacao DATETIME NOT NULL,

    CONSTRAINT fk_respostas_autor FOREIGN KEY (id_Autor) REFERENCES Autores(id),
    CONSTRAINT fk_respostas_topico FOREIGN KEY (id_Topico) REFERENCES Topicos(id)
);