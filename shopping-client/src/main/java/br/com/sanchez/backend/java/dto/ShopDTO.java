package br.com.sanchez.backend.java.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    private Float total;
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

}