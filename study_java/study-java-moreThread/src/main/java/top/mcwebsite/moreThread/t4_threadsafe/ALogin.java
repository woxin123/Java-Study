package top.mcwebsite.moreThread.t4_threadsafe;

/**
 * @author mengchen
 * @time 18-8-13 下午4:26
 */
public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
