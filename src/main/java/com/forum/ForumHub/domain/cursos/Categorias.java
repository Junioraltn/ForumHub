package com.forum.ForumHub.domain.cursos;

public enum Categorias {
    GERAL("Geral"),
    TECNOLOGIA("Tecnologia em geral"),
    PROGRAMACAO("Programação"),
    CIENCIA_DE_DADOS("Ciência de Dados"),
    INTELIGENCIA_ARTIFICIAL("Inteligência Artificial"),
    DEVOPS("DevOps"),
    SEGURANCA_DA_INFORMACAO("Segurança da Informação"),
    BANCO_DE_DADOS("Banco de Dados"),
    FRONT_END("Front-end"),
    BACK_END("Back-end"),
    MOBILE("Mobile"),
    OUTROS("Outros");

    private String descricao;

    Categorias(String descricao) {
        this.descricao = descricao;
    }

    public static Categorias fromString(String text) {
        for (Categorias categoria : Categorias.values()) {
            if (categoria.descricao.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public String getDescricao() {
        return descricao;
    }

}
