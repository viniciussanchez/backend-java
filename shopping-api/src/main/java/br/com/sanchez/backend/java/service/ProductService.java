package br.com.sanchez.backend.java.service;

import br.com.sanchez.backend.java.dto.ProductDTO;
import br.com.sanchez.backend.java.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public ProductDTO getProductByIdentifier(final String productIdentifier) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8081/products/" + productIdentifier;
            ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new ProductNotFoundException();
        }
    }

}