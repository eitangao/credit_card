package com.xmx.credit_card.dao;

import com.xmx.credit_card.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user where acct=#{account}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account",column = "acct"),
            @Result(property = "password", column = "pass_word"),
            @Result(property = "userName", column = "name"),
            @Result(property = "idCard",column = "id_card"),
            @Result(property = "point",column = "point"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "idPicture",column = "id_pict"),
            @Result(property = "createTime", column = "create_time")
    })
    User getUserByAccount(String  account);
    @Select("select id from user where acct=#{account}")
    @Results({
            @Result(property = "id",column = "id")
    })
    Long getUserIdByAccount(String account);
    @Insert("insert into user(acct,pass_word,name,id_card,point,amount,id_pict,create_time)" +
            " values(#{account},#{password},#{userName},#{idCard},#{point},#{amount},#{idPicture},#{createTime})")
    void addUser(User user);

}
