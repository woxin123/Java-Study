package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.model.SysRole;
import com.example.mybatisstudy.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRolesByUserId(Integer userId);
    Integer insert(SysUser user);
    Integer insert2(SysUser user);
    Integer insert3(SysUser user);
    Integer updateById(SysUser sysUser);
    Integer deleteById(Long id);
    Integer deleteById(SysUser user);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);

    List<SysUser> selectByUser(SysUser sysUser);

    Integer updateByIdSelective(SysUser sysUser);

    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 根据用户id集合查询
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 批量插入用户
     * @param sysUsers
     * @return
     */
    int insertList(List<SysUser> sysUsers);

    /**
     *
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);

    /**
     * 根据用户id获取用户信息和用户角色信息
     * @param id
     * @return
     */
    SysUser selectUserAndRoleById(Long id);


    SysUser selectUserAndRoleById2(Long id);

    SysUser selectUserAndRoleByIdSelect(Long id);

    /**
     * 获取所有用户以及对应的角色
     * @return
     */
    List<SysUser> selectAllUserAndRoles();

    /**
     * 通过嵌套获取指定用户的信息以及用户角色和权限
     */
    SysUser selectAllUserAndRolesSelect(Long id);

    /**
     * 使用存储过程查询用户信息
     */
    void selectUserById(SysUser user);


    List<SysUser> selectUserPage(Map<String, Object> params);

    /**
     * 保存用户信息和角色信息
     * @param user
     * @param roleIds
     * @return
     */
    int insertUserAndRoles(@Param("user") SysUser user, @Param("rolesId") String rolesId);

    /**
     * 根据用户id删除用户和用户信息
     * @param id
     * @return
     */
    int deleteUserById(Long id);
}
