
package com.store.vo;

import java.time.LocalDate;

public class ReportVo {

    private final String productName;
    private final Long salesQuantity;
    private final LocalDate dateLastSale;

    public ReportVo(String productName, Long salesQuantity, LocalDate dateLastSale) {
        this.productName = productName;
        this.salesQuantity = salesQuantity;
        this.dateLastSale = dateLastSale;
    }

    public String getProductName() {
        return productName;
    }

    public Long getSalesQuantity() {
        return salesQuantity;
    }

    public LocalDate getDateLastSale() {
        return dateLastSale;
    }

    @Override
    public String toString() {
        return "productName = " + productName +
                ", salesQuantity = " + salesQuantity +
                ", dateLastSale = " + dateLastSale;
    }
}
