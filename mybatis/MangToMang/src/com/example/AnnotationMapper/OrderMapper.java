package com.example.AnnotationMapper;

import com.example.domain.Article;
import com.example.domain.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "code", column = "code"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "user_id",
                one=@One(select="com.example.AnnotationMapper.UserMapper.selectUserById",fetchType = FetchType.LAZY)),
            @Result(property = "articles", column = "id",
                many=@Many(select = "com.example.AnnotationMapper.ArticleMapper.selectByOrderId", fetchType = FetchType.LAZY))
    })
    Order selectById(int id);
}
