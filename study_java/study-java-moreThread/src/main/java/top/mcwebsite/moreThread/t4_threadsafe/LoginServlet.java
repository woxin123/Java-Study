package top.mcwebsite.moreThread.t4_threadsafe;

/**
 * 本类模拟一个Servlet组件
 * @author mengchen
 * @time 18-8-13 下午4:22
 */
public class LoginServlet {

    private static String usernameRef;

    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " passwordRef=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
