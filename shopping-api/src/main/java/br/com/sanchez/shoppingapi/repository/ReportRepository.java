package br.com.sanchez.shoppingapi.repository;

import br.com.sanchez.shoppingapi.dto.ShopReportDTO;
import br.com.sanchez.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(final Date dataInicio, final Date dataFim, final Float valorMinimo);
    public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim);

}