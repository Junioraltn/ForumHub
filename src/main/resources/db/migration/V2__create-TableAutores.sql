CREATE TABLE Autores(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(60) NOT NULL,
    id_perfil INT NOT NULL,

    CONSTRAINT unique_email_autores UNIQUE (email),
    CONSTRAINT fk_Autores_perfil FOREIGN KEY (id_perfil) REFERENCES Perfis(id)
);

--INSERT INTO Autores
--    VALUES(1,'Pedro','pedro@forumhub.com','$2a$10$HXKMAWlG5vxu0mbXsbwk3eTyMDEkHXob4nx2nkuJQi7QOmW9mHRmG',2),
--    (2,'Maria','maria@forumhub.com','$2a$10$HXKMAWlG5vxu0mbXsbwk3eTyMDEkHXob4nx2nkuJQi7QOmW9mHRmG',1);