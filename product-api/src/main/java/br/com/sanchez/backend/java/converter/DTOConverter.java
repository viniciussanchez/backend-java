package br.com.sanchez.backend.java.converter;

import br.com.sanchez.backend.java.dto.CategoryDTO;
import br.com.sanchez.backend.java.dto.ProductDTO;
import br.com.sanchez.backend.java.model.Category;
import br.com.sanchez.backend.java.model.Product;

public class DTOConverter {

    public static CategoryDTO convert(final Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(final Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        if (product.getCategory() != null) {
            productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }

}