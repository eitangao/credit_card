package com.xmx.credit_card.dao;

import com.xmx.credit_card.entity.Goods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface GoodsMapper {

    List<Goods> getGoodsByCondition(Map map);
    Goods list();

    Goods getGoodsById(@Param("id") Long id);


}