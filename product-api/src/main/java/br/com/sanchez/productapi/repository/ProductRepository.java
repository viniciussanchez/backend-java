package br.com.sanchez.productapi.repository;

import br.com.sanchez.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.nome, p.preco, p.productIdentifier, p.descricao from product p " +
            "join category c on p.category.id = c.id " +
            "where c.id = :categoryId")
    public List<Product> getProductByCategory(@Param("categoryId") long categoryId);

    public Product findByProductIdentifier(String productIdentifier);

}