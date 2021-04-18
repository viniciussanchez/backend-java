package br.com.sanchez.productapi.dto;

import br.com.sanchez.productapi.model.Product;

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
    private CategoryDTO categoryDTO;

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

    public CategoryDTO getCategoryDTO() {
        return this.categoryDTO;
    }

    public void setCategoryDTO(final CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public static ProductDTO convert(final Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }

}