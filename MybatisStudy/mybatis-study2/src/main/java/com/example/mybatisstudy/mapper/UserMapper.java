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
}
