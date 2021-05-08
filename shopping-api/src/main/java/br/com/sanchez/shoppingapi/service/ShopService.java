package br.com.sanchez.shoppingapi.service;

import br.com.sanchez.shoppingapi.dto.ShopDTO;
import br.com.sanchez.shoppingapi.dto.ShopReportDTO;
import br.com.sanchez.shoppingapi.model.Shop;
import br.com.sanchez.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(final String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(final ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public ShopDTO findById(final long id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(final ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);
        return ShopDTO.convert(shop);
    }

    public List<ShopDTO> getShopByFilter(final Date dataInicio, final Date dataFim, final Float valorMinimo) {
        List<Shop> shops = shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);
    }

}