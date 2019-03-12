package top.mcwebsite.netty.aio;

/**
 * @author mengchen
 * @time 19-3-12 下午4:42
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException ignore) {

            }
        }

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);

        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
