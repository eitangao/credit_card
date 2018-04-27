package com.xmx.credit_card.entity;

import java.util.Date;

public class ShoppingCart {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.product_id
     *
     * @mbggenerated
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.product_number
     *
     * @mbggenerated
     */
    private Integer productNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.acct
     *
     * @mbggenerated
     */
    private String acct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.id
     *
     * @return the value of shopping_cart.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.id
     *
     * @param id the value for shopping_cart.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.product_id
     *
     * @return the value of shopping_cart.product_id
     *
     * @mbggenerated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.product_id
     *
     * @param productId the value for shopping_cart.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.product_number
     *
     * @return the value of shopping_cart.product_number
     *
     * @mbggenerated
     */
    public Integer getProductNumber() {
        return productNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.product_number
     *
     * @param productNumber the value for shopping_cart.product_number
     *
     * @mbggenerated
     */
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.acct
     *
     * @return the value of shopping_cart.acct
     *
     * @mbggenerated
     */
    public String getAcct() {
        return acct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.acct
     *
     * @param acct the value for shopping_cart.acct
     *
     * @mbggenerated
     */
    public void setAcct(String acct) {
        this.acct = acct == null ? null : acct.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.create_time
     *
     * @return the value of shopping_cart.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.create_time
     *
     * @param createTime the value for shopping_cart.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}