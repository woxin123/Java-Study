package com.example.AnnotationMapper;

import com.example.domain.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface ClazzMapper {
    @Select("select * from tb_clazz where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(column = "id", property = "students",
            many = @Many(select = "com.example.AnnotationMapper.StudentMapper.selectByClazzId",
                fetchType = FetchType.LAZY))
    })
    Clazz selectById(int id);
}
