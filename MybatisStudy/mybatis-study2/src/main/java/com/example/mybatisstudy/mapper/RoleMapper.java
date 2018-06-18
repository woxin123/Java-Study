package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.model.SysRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
// 接口二级缓存配置
@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    @Select({"select id, role_name roleName, enabled, create_by createBy, create_time createTime " +
            "from sys_role where id = #{id}"})
    SysRole selectById(Long id);

    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
    })
    @Select("select id, role_name, enabled, create_by, create_time " +
            "from sys_role where id = #{id}")
    SysRole selectById2(Long id);

    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) " +
            "VALUES(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType = TIMESTAMP})"})
    int insert(SysRole sysRole);

    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) " +
            "VALUES(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType = TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    @Insert({"INSERT INTO sys_role(role_name, enabled, create_by, create_time) " +
            "VALUES(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType = TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    int insert3(SysRole sysRole);

    @Update({"UPDATE sys_role SET role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, " +
            "create_time = #{createTime, jdbcType = TIMESTAMP} WHERE id = #{id}"})
    Integer updateById(SysRole sysRole);

    @Delete("DELETE from sys_role WHERE id = #{id}")
    Integer deleteById(Long id);

    /**
     * 查询所有的角色
     * @return
     */
    List<SysRole> selectAllRoleAndPrivileges();

    /**
     * 根据用户ID获取用户角色信息
     */
    List<SysRole> selectRoleByUserIdChoose(Long userId);
}

