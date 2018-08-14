package top.mcwebsite.moreThread.t4_threadsafe;

/**
 * @author mengchen
 * @time 18-8-13 下午4:27
 */
public class BLogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
