package com.xmx.credit_card.dao;

import com.xmx.credit_card.entity.Card;

public interface CardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String cardNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    int insert(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    int insertSelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    Card selectByPrimaryKey(String cardNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Card record);
}