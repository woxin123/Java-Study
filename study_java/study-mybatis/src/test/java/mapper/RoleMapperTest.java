package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import top.mcwebsite.study_mybatis.mapper.UserMapper;
import top.mcwebsite.study_mybatis.model.SysUser;

/**
 * @author mengchen
 * @time 18-12-24 下午8:32
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectById方法，查询id = 1的用户
            SysUser user = userMapper.selectById(1L);
            // user不为空
            Assert.assertNotNull(user);
            // userName = admin
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            // 不要忘记关闭sqlSession
            sqlSession.close();
        }
    }
}
