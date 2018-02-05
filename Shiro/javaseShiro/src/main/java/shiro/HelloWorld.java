package shiro;


import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {
    private static final Logger logger = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.info("HelloWorld!");
        /**
         * 1. 获取安全管理器
         * 2. 获取用户
         * 3. 用户登录
         * 4. 权限管理
         * 5. 角色管理
         * 6. session 用户登录到用户退出
         */
        // 1. 获取安全管理器
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        // 2. 设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 3. 获取Subject对象，即登录的用户
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("name", "张三");
        String value = (String) session.getAttribute("name");
        if (value != null) {
            logger.info(value);
        }
        // 判断是否拥有指定的角色
        if (!currentUser.isAuthenticated()) {
            // UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken("root", "admin123");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                logger.info("用户名和密码正确，登录成功");
            } catch (UnknownAccountException e) {
                logger.info("账户不存在");
            } catch (IncorrectCredentialsException e) {
                logger.info("密码错误");
            } catch (LockedAccountException e) {
                logger.info("用户已经锁死");
            } catch (AuthenticationException e) {
                logger.info("认证异常");
            }
        }

        if (currentUser.hasRole("admin")) {
            logger.info("拥有指定角色");
        } else {
            logger.info("不用有指定的角色");
        }

         // currentUser.isPermitted(String)
        if (currentUser.isPermitted("*")) {
            logger.info("当前用户拥有指定的权限");
        } else {
            logger.info("当前用户不拥有指定的权限");
        }
        // 退出登录
        currentUser.logout();
    }
}
