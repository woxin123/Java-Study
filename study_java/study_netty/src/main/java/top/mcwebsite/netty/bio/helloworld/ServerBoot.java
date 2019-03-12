package top.mcwebsite.netty.bio.helloworld;

/**
 * @author mengchen
 * @time 19-3-3 下午5:05
 */
public class ServerBoot {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }

}
