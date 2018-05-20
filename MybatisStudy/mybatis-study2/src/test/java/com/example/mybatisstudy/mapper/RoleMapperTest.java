package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.BaseMapperTest;
import com.example.mybatisstudy.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            assertNotNull(role);
            assertEquals("管理员", role.getRoleName());
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testSelectById2() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById2(1L);
            assertNotNull(role);
            assertEquals("管理员", role.getRoleName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert1() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role = new SysRole();
            role.setRoleName("普通用户");
            role.setCreateBy(1L);
            role.setCreateTime(new Date());
            role.setEnabled(1);
            int result = roleMapper.insert(role);
            assertEquals(1, result);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("普通用户");
            role.setCreateBy(1L);
            role.setCreateTime(new Date());
            role.setEnabled(1);
            int result = roleMapper.insert2(role);
            System.out.println(role.getId());
            assertEquals(1, result);
            assertNotNull(role.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = new SysRole();
            role.setRoleName("普通用户");
            role.setCreateBy(1L);
            role.setCreateTime(new Date());
            role.setEnabled(1);
            int result = roleMapper.insert3(role);
            System.out.println(role.getId());
            assertEquals(1, result);
            assertNotNull(role.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testUpdate() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            role.setRoleName("普通用户");
            role.setCreateTime(new Date());
            role.setEnabled(1);
            int result = roleMapper.updateById(role);
            assertEquals(1, result);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int result = roleMapper.deleteById(1L);
            assertEquals(1, result);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
