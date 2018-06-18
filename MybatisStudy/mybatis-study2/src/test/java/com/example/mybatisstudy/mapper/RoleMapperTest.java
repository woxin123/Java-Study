package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.BaseMapperTest;
import com.example.mybatisstudy.model.SysPrivilege;
import com.example.mybatisstudy.model.SysRole;
import com.example.mybatisstudy.type.Enabled;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
            role.setEnabled(Enabled.enabled);
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
            role.setEnabled(Enabled.enabled);
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
            role.setEnabled(Enabled.enabled);
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
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);
            assertEquals(Enabled.enabled, role.getEnabled());
            role.setCreateTime(new Date());
            role.setEnabled(Enabled.disabled);
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


    @Test
    public void testSelectAllRoleAndPrivileges() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roles = roleMapper.selectAllRoleAndPrivileges();
            assertNotNull(roles);
            for (SysRole role : roles) {
                System.out.println("角色名：" + role.getRoleName());
                List<SysPrivilege> privileges = role.getPrivilegeList();
                for (SysPrivilege privilege : privileges) {
                    System.out.println("权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testSelectRoleByUserIdChoose() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(2L);
            role.setEnabled(Enabled.disabled);
            roleMapper.updateById(role);
            // 获取用户为1的角色
            List<SysRole> roles = roleMapper.selectRoleByUserIdChoose(2L);
            for (SysRole r : roles) {
                System.out.println("角色名：" + r.getRoleName());
                if (r.getId().equals(1L)) {
                    // 第一个的角色存在权限信息
                    assertNotNull(r.getPrivilegeList());
                } else if (r.getId().equals(2L)) {
                    // 第二个角色的权限为null
                    assertNull(r.getPrivilegeList());
//                    continue;
                }
                for (SysPrivilege privilege : r.getPrivilegeList()) {
                    System.out.println("权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            sqlSession.close();
        }

    }

}
