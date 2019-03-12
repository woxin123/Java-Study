package top.mcwebsite.netty.bio.helloworld;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mengchen
 * @time 19-3-3 下午4:56
 */
public class Server {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动端口成功");
        } catch (IOException e) {
            System.out.println("服务端启动端口失败");
        }
    }

    public void start() {
        new Thread(() -> {
            doStart();
        }).start();
    }

    public void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }

        }
    }
}
