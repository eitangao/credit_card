package com.xmx.credit_card.dto;

import com.xmx.credit_card.constant.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 推荐商品
 */
public class HotProduct {

    private Long productId;

    private LocalDateTime createTime;

    private BigDecimal price;

    private ProductType productType;

    private Integer hotPoint=0;

    private Double hotType=0.0;

    private Double purchasingPower=0.0;

    private Double finalPoint;

    public Double getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Double finalPoint) {
        this.finalPoint = finalPoint;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getHotPoint() {
        return hotPoint;
    }

    public void setHotPoint(Integer hotPoint) {
        this.hotPoint = hotPoint;
    }

    public Double getHotType() {
        return hotType;
    }

    public void setHotType(Double hotType) {
        this.hotType = hotType;
    }

    public Double getPurchasingPower() {
        return purchasingPower;
    }

    public void setPurchasingPower(Double purchasingPower) {
        this.purchasingPower = purchasingPower;
    }
}
