package top.mcwebsite.spring.cache.mycache;

/**
 * @author mengchen
 * @time 18-10-7 下午2:22
 */
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // 开始查询
        userService.getUserById("001001");
        userService.getUserById("001001");

        // 重置缓存
        userService.reload();

        System.out.println("after reload");

        userService.getUserById("001001");

        userService.getUserById("001001");
    }
}
