package br.com.sanchez.shoppingapi.dto;

import br.com.sanchez.shoppingapi.model.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public ItemDTO() {
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public void setProductIdentifier(final String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(final Float price) {
        this.price = price;
    }

    public static ItemDTO convert(final Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

}