package top.mcwebsite.netty.bio.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author mengchen
 * @time 19-3-3 下午5:06
 */
public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;
    public static final int MAX_DATA_LEN = 1024;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(() -> {
            System.out.println("客户端启动成功");
            while (true) {
                try {
                    String message = "hello world";
                    System.out.println("客户端发送数据：" + message);
                    socket.getOutputStream().write(message.getBytes());
                } catch (Exception e) {
                    System.out.println("写数据出错");
                }
                sleep();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] data = new byte[MAX_DATA_LEN];
                    int len;
                    while ((len = inputStream.read(data)) != -1) {
                        String message = new String(data, 0, len);
                        System.out.println("服务器传来消息：" + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
