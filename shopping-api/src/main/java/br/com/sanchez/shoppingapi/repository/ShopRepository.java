package br.com.sanchez.shoppingapi.repository;

import br.com.sanchez.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    public List<Shop> findAllByUserIdentifier(final String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(final Float total);
    List<Shop> findAllByDateGreaterThan(final Date date);

}