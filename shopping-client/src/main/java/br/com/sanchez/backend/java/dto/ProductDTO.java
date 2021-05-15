package br.com.sanchez.backend.java.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoryDTO category;

    public ProductDTO() {
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(final Float preco) {
        this.preco = preco;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

    public void setCategory(final CategoryDTO category) {
        this.category = category;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

}