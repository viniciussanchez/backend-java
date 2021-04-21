package br.com.sanchez.shoppingapi.dto;

import br.com.sanchez.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Date date;
    @NotNull
    private List<ItemDTO> items;

    public ShopDTO() {
    }

    public String getUserIdentifier() {
        return this.userIdentifier;
    }

    public void setUserIdentifier(final String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return this.total;
    }

    public void setTotal(final Float total) {
        this.total = total;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public List<ItemDTO> getItems() {
        return this.items;
    }

    public void setItems(final List<ItemDTO> items) {
        this.items = items;
    }

    public static ShopDTO convert(final Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }

}