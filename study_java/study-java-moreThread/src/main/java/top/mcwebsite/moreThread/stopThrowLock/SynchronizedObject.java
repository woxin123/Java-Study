package top.mcwebsite.moreThread.stopThrowLock;

/**
 * 使用stop()释放锁将会给数据造成不一致行结果。如果出现这样的情况，
 * 程序处理数据就可能遭到破坏。
 * @author mengchen
 * @time 18-8-14 下午2:34
 */
public class SynchronizedObject {

    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
