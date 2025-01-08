package com.forum.ForumHub.domain.cursos;

public enum CursosEnum {
    Engenharia_de_Produção("Engenharia de Produção"),
    Ciência_De_Dados("Ciência de Dados"),
    Matemática("Matemática");

    private String curso;

    CursosEnum(String s) {
        this.curso = s;
    }

    public String getCurso(){
        return curso;
    }
    public static CursosEnum fromString(String text) {
        for (CursosEnum categoria : CursosEnum.values()) {
            if (categoria.curso.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhum curso encontrado para a string fornecida: " + text);
    }
}
