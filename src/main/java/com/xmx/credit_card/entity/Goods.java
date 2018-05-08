package com.xmx.credit_card.entity;

import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Goods {

    private Long id;

    private String name;

    private BigDecimal price;

    private Integer point;

    private ProductType productType;

    private ApplicaplePeople applicaplePeople;

    private Integer count;

    private String picture;

    private LocalDateTime createTime;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ApplicaplePeople getApplicaplePeople() {
        return applicaplePeople;
    }

    public void setApplicaplePeople(ApplicaplePeople applicaplePeople) {
        this.applicaplePeople = applicaplePeople;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
