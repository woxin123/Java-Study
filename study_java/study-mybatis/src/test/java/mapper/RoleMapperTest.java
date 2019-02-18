package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import top.mcwebsite.study_mybatis.mapper.RoleMapper;
import top.mcwebsite.study_mybatis.mapper.UserMapper;
import top.mcwebsite.study_mybatis.model.SysRole;
import top.mcwebsite.study_mybatis.model.SysUser;

/**
 * @author mengchen
 * @time 18-12-24 下午8:32
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(1);
            System.out.println(sysRole);
        } finally {
            // 不要忘记关闭sqlSession
            sqlSession.close();
        }
    }
}
