package com.xmx.credit_card.dao;

import java.math.BigDecimal;
import java.util.List;

import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.entity.CardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CardMapper {
    int countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(String cardNumber);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(String cardNumber);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    @Select("select count(*)  from card group by card_type")
    List<Integer> countCardGroupByCardType();

    @Select("select count(*)  from card group by acct")
    List<Integer> countCardGroupByAcct();

    @Select("select sum(card_point) from card where acct=#{account} group by card_number")
    List<Integer> sumCardPointByCard(String account);

    @Select("update event set amount=#{arg2},point=#{arg1} where card_number=#{arg0}")
    void eventRepay(String cardNumber, Integer point, BigDecimal amount);

    @Select("update card set amount=#{arg1} where card_number=#{arg0}")
    void play(String cardNumber, Integer point);
}