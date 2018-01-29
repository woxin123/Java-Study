package com.example.AnnotationMapper;

import com.example.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from tb_student2 where clazz_id = #{id}")
    List<Student> selectByClazzId(int id);
}
