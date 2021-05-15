package br.com.sanchez.backend.java.repository;

import br.com.sanchez.backend.java.dto.ShopReportDTO;
import br.com.sanchez.backend.java.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(final Date dataInicio, final Date dataFim, final Float valorMinimo);
    public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim);

}