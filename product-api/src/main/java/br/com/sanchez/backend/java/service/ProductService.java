package br.com.sanchez.backend.java.service;

import br.com.sanchez.productapi.dto.ProductDTO;
import br.com.sanchez.backend.java.model.Product;
import br.com.sanchez.backend.java.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(final Long categoryId) {
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(final String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }

    public ProductDTO save(final ProductDTO productDTO) {
        Product product = productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    public ProductDTO delete(final long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
        return null;
    }

}