# 📚Forum Hub

## 📝Descrição do Projeto

Trata-se de uma API REST utilizando o Spring Boot, para replicar o processo de armazenamento, tratamento de dados e relacionamento entre as tabelas, no nível do back end que ocorre em um fórum em uma plataforma de ensino. Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos, ou seja, um lugar de muita aprendizagem e colaboração entre alunos, professores e moderadores.


### Requisitos:


|           |                      |
|-----------|----------------------|
| Java JDK: | versão: 17 em diante |
| Maven:    | versão 4 em diante   |
|Spring Boot| (versão 3.2.3)|
|MySQL| versão 4 em diante|
|Insominia:|versão16 em diante|
|IDEA:|IntelliJ (_opcional_)|
##### Dependências
|           |                      |       ||
|-----------|----------------------|-------|--|
| Lombok  | Spring Boot DevTools |Flyway Migration|Validation|
| Spring Web | Spring Data JPA |MySQL Driver|Spring Security|


### Etapas do Desafio
- Configuração do ambiente Java;
- Criar banco de dados; 
- Criar tabelas através de Migration, com base no Diagrama EER;
- Criar e mapear as classes com base nas tabelas criadas;
- Desenvolver o CRUD;
- Criar medidas de autenticação/autorização.


### 🛠️Funcionalidades:

Nesta API o foco inicial será especificamente nos tópicos (do forúm), e será aplicado o CRUD (CREATE, READ, UPDATE, DELETE), ou seja, permite que os usuários:

1. Criem um novo tópico (CREATE - Criar);
2. Mostrar todos os tópicos criados (READ - Consultar);
3. Mostrar um tópico específico (READ - Consultar);
4. Atualizar um tópico (UPDATE - Atualizar);
5. Eliminar um tópico (DELETE - Deletar).

#### Objetivos Funcionais
* **Melhores práticas:** API com rotas implementadas seguindo as melhores práticas do modelo REST;
* **Validações:** Validações realizadas segundo as regras de negócio;
* **Persistência de Dados:** Implementação de uma base de dados relacional para a persistência da informação;
* **autenticação/autorização:** Serviço de autenticação/autorização para restringir o acesso à informação.


### 🏛️Estrutura do projeto:
O projeto está organizado da seguinte forma:

* **domain:** Contém as classes que representam os dados do domínio, como `autores`, `cursos`, `perfis` e `topicos`.
* **repository:** Define as interfaces que interagem com o banco de dados, utilizando Spring Data JPA.
* **service:** Encapsula a lógica de negócio, como a consulta à API, a conversão de JSON e a persistência de dados.
* **controller:** Gerencia as requisições HTTP, mapeando-as para os métodos apropriados nos serviços, e retorna as respostas adequadas ao cliente.
* **infra:** Cuida da parte de segurança, tratamento de exceções e outras configurações de infraestrutura necessárias para o funcionamento da aplicação.


**Diagrama de Entidade Relacionamento ExtendidoEstendido:**
![EER Diagram](https://github.com/user-attachments/assets/34d78123-cea4-4424-aa67-c13d9ec6f34b)


### 🧷Trabalhos Futuros:
* **Tratar Perfils como Enum:** Padronizar os possíveis perfis dá mais controle e permite no futuro implementar atribuição de diferentes permissões de acesso entre outras funcionalidades especificas para cada perfil.


**Observação:** Este projeto está em constante desenvolvimento. Novas funcionalidades e melhorias serão adicionadas regularmente.

### 🫡Contribuições:

Contribuições são bem-vindas! Se você encontrar algum bug ou tiver alguma sugestão de melhoria, por favor, abra um issue neste repositório.

### 🔓Licença:

Este projeto está licenciado sob a licença MIT.
