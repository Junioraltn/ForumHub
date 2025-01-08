CREATE TABLE Perfis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL

    CONSTRAINT unique_nome_perfis UNIQUE(nome)
);

--INSERT INTO Perfis
--    VALUES (1,'Administrador'),
--            (2,'Usuario');