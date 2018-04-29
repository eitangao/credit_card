package com.xmx.credit_card.dto;

import java.time.LocalDateTime;

public class PointDetail {

    private Long productId;

    private String productName;

    private Integer point;

    private LocalDateTime createTIme;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public LocalDateTime getCreateTIme() {
        return createTIme;
    }

    public void setCreateTIme(LocalDateTime createTIme) {
        this.createTIme = createTIme;
    }
}
