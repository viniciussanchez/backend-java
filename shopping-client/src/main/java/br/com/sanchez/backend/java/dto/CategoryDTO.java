package br.com.sanchez.backend.java.dto;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;

    public CategoryDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

}