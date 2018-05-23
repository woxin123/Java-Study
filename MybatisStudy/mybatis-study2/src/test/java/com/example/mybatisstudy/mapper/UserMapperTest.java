package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.BaseMapperTest;
import com.example.mybatisstudy.model.SysRole;
import com.example.mybatisstudy.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectAll方法查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            // 结果不为空
            Assert.assertNotNull(userList);
            System.out.println(userList);
            Assert.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectAll方法查询所有用户
            List<SysRole> roleList = userMapper.selectRolesByUserId(1);
            // 结果不为空
            Assert.assertNotNull(roleList);
            System.out.println(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.com");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert(user);
            assertEquals(1, result);
            Assert.assertNull(user.getId());
        } finally {
            // 为了不影响其它的测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不会自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.com");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert2(user);
            assertEquals(1, result);
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其它的测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不会自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.com");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert3(user);
            assertEquals(1, result);
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其它的测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不会自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 从数据库查询1个user对象
            SysUser user = userMapper.selectById(1L);
            // 当前username为admin
            assertEquals("admin", user.getUserName());
            // 修改用户名
            user.setUserName("admin_test");
            // 更新数据
            int result = userMapper.updateById(user);
            assertEquals(1, result);
            // 根据id查询
            user = userMapper.selectById(1L);
            // 修改后的名字是admin_test
            assertEquals("admin_test", user.getUserName());
        } finally {
            // 为了不影响其它的测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不会自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 从数据库查询1个user对象
            SysUser user1 = userMapper.selectById(1L);
            assertNotNull(user1);
            assertEquals(Integer.valueOf(1), userMapper.deleteById(1L));
            assertNull(userMapper.selectById(1L));

            SysUser user2 = userMapper.selectById(1001L);
            assertNotNull(user2);
            assertEquals(Integer.valueOf(1), userMapper.deleteById(user2));
            assertNull(userMapper.selectById(1001L));
        } finally {
            // 为了不影响其它的测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不会自动提交的
            // 因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);

            assertNotNull(roleList);
            assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 只查询用户名
            SysUser query = new SysUser();
            query.setUserName("ad");
            List<SysUser> userList = userMapper.selectByUser(query);
            assertTrue(userList.size() > 0);
            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@mybatis.com");
            userList = userMapper.selectByUser(query);
            assertTrue(userList.size() == 1);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByIdSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            user.setUserEmail("test@mybatis.com");
            int result = userMapper.updateByIdSelective(user);
            assertEquals(1, result);
            user = userMapper.selectById(1L);
            assertEquals("admin", user.getUserName());
            assertEquals("test@mybatis.com", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2Selective() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个对象
            SysUser user = new SysUser();
            user.setUserName("test-selective");
            user.setUserPassword("1234567");
            user.setUserInfo("test info");
            user.setCreateTime(new Date());
            userMapper.insert2(user);
            user = userMapper.selectById(user.getId());
            assertEquals("test@mybatis.org", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdOrUserName() {
        SqlSession sqlSesion = getSqlSession();
        try {
            UserMapper userMapper = sqlSesion.getMapper(UserMapper.class);
            // 只查询用户名时
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("admin");
            SysUser user = userMapper.selectByIdOrUserName(query);
            assertNotNull(user);
            // 当没有id时
            query.setId(null);
            user = userMapper.selectByIdOrUserName(query);
            assertNotNull(user);
            // 当id和name都为空时
            query.setUserName(null);
            user = userMapper.selectByIdOrUserName(query);
            assertNull(user);
        } finally {
            sqlSesion.close();
        }
    }


    @Test
    public void testSelectByIdList() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<>();
            idList.add(1L);
            idList.add(1001L);
            List<SysUser> userList = userMapper.selectByIdList(idList);
            assertEquals(2, userList.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertList() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个user对象
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123456");
                user.setUserEmail("test@mybatis.com");
                userList.add(user);
            }
            int result = userMapper.insertList(userList);
            assertEquals(2, result);
            for (SysUser user : userList) {
                System.out.println(user.getId());
            }
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByMap() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            // 查询条件，同样也是更新字段，必须保证该值存在
            map.put("id", 1L);
            // 要更新的其他字段
            map.put("user_email", "test@mybatis.com");
            map.put("user_password", "12345678");
            // 更新数据
            userMapper.updateByMap(map);
            // 根据当前的id查询修改后的数据
            SysUser user = userMapper.selectById(1L);
            assertEquals("test@mybatis.com", user.getUserEmail());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
