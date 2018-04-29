package com.xmx.credit_card.dao;

import com.xmx.credit_card.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

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
            @Result(property = "status",column = "status"),
            @Result(property = "createTime", column = "create_time")
    })
    User getUserByAccount(String  account);
    @Select("select * from user}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account",column = "acct"),
            @Result(property = "password", column = "pass_word"),
            @Result(property = "userName", column = "name"),
            @Result(property = "idCard",column = "id_card"),
            @Result(property = "point",column = "point"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "idPicture",column = "id_pict"),
            @Result(property = "status",column = "status"),
            @Result(property = "createTime", column = "create_time")
    })
    List<User> getUserList();
    @Select("select id from user where acct=#{account}")
    @Results({
            @Result(property = "id",column = "id")
    })
    Long getUserIdByAccount(String account);
    @Select("select amount from user where acct=#{account}")
    @Results({
            @Result(property = "amount",column = "amount")
    })
    BigDecimal getAmountByAccount(String account);
    @Insert("insert into user(acct,pass_word,name,id_card,point,amount,id_pict,create_time)" +
            " values(#{account},#{password},#{userName},#{idCard},#{point},#{amount},#{idPicture},#{createTime})")
    void addUser(User user);
    @Update("update user set amount = #{amount} where acct = #{account}")
    void updateAmount(String account,BigDecimal amount);
    @Update("update user set point = #{point} where acct = #{account}")
    void updatePoint(String account,Integer point);
    @Update("update user set pass_word = #{password}, name = #{userName}, id_card = #{idCard}, id_pict =#{idPicture}" +
            " where id = #{id} ")
    void updateUserInfo(User user);
    @Update("update user set status = 0 where acct = #{account}")
    void frozeAccount(String account);


}
