package br.com.sanchez.productapi.dto;

import br.com.sanchez.productapi.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;
    @NotBlank
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

    public static CategoryDTO convert(final Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

}