package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.BaseMapperTest;
import com.example.mybatisstudy.model.SysRole;
import com.example.mybatisstudy.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTest extends BaseMapperTest {

    @Test
    public void testL1Cache() {
        SqlSession sqlSession = getSqlSession();
        SysUser user1 = null;
        try {
            // 获取UserMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectById方法，查询id = 1的用户
            user1 = userMapper.selectById(1L);
            // 对当前对象重新赋值
            user1.setUserName("New Name");
            // 在此查询获取id相同的用户
            SysUser user2 = userMapper.selectById(1L);
            // 虽然没有更新数据库，但是这个用户名和user1重新赋值的名字相同
            assertEquals("New Name", user2.getUserName());
            // 无论如何，user2和user1完全就是同一个实例
            assertEquals(user1, user2);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testL2Cache() {
        SqlSession sqlSession = getSqlSession();
        SysRole role1 = null;
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            role1 = roleMapper.selectById(2L);
            role1.setRoleName("New Name");
            SysRole role2 = roleMapper.selectById(2L);
            assertEquals("New Name", role2.getRoleName());
            assertEquals(role1, role2);
        } finally {
            sqlSession.close();
        }
        System.out.println("开启一个新的sqlSession");
        sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role2 = roleMapper.selectById(2L);
            assertEquals("New Name", role2.getRoleName());
            assertEquals(role1, role2);
            SysRole role3 = roleMapper.selectById(2L);
            assertEquals(role2, role3);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDirtyData() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectUserAndRoleById(1001L);
            assertEquals("普通用户", user.getRole().getRoleName());
            System.out.println("角色名：" + user.getRole().getRoleName());

        } finally {
            sqlSession.close();
        }
        sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(2L);
            role.setRoleName("脏数据");
            roleMapper.updateById(role);
            // 提交修改
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysUser user = userMapper.selectUserAndRoleById(1001L);
            SysRole role = roleMapper.selectById(2L);
            assertEquals("普通用户", user.getRole().getRoleName());
            assertEquals("脏数据", role.getRoleName());
            System.out.println("普通用户");
            roleMapper.updateById(role);
        } finally {
            sqlSession.close();
        }
    }
}
