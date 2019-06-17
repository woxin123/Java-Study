import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * UDP 搜索者，用于搜索服务支持方
 * @author mengchen
 * @time 19-5-7 上午11:25
 */
public class UDPSearcher {

    private static final int LISTEN_PORT = 3000;



    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("UDPSearcher Started");
        Listener listen = listen();
        sendBroadcast();

        // 从键盘读入信息后可以退出
        System.in.read();

        List<Device> devices = listen.getDevicesAndClose();

        for (int i = 0; i < devices.size(); i++) {
            System.out.println("Device: " + devices);
        }

        // 完成
        System.out.println("UDPSearcher Finished.");
    }

    public static Listener listen() throws InterruptedException {
        System.out.println("UDPSearcher start listener.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LISTEN_PORT ,countDownLatch);
        listener.start();
        countDownLatch.await();
        return listener;
    }

    private static void sendBroadcast() throws IOException {
        System.out.println("UDPSearcher snedBroadcast Started.");

        // 作为搜索方，无须指定端口，让系统自动分配
        DatagramSocket ds = new DatagramSocket();

        // 构建一份发送数据
        String requestData = MessageCreator.buildWithPort(LISTEN_PORT);
        byte[] requestDataBytes = requestData.getBytes();
        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes,
                requestDataBytes.length);

        // 本机端口20000
        requestPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        requestPacket.setPort(20000);

        ds.send(requestPacket);
        ds.close();

        // 完成
        System.out.println("UDPSearcher Broadcast Finished.");
    }

    private static class Device {
        final int port;
        final String ip;
        final String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip=" + ip +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    private static class Listener extends Thread {
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;

        public Listener(int listenPort, CountDownLatch countDownLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            // 通知已经启动
            countDownLatch.countDown();
            try {
                // 监听回送端口
                this.ds = new DatagramSocket(listenPort);
                while (!done){

                    // 构建接收实体
                    final byte[] buf = new byte[512];
                    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

                    // 接收
                    ds.receive(receivePack);

                    // 打印接收到的信息与发送者的信息
                    // 发送者的IP地址
                    String ip = receivePack.getAddress().getHostAddress();
                    int port = receivePack.getPort();
                    int dataLength = receivePack.getLength();

                    String data = new String(receivePack.getData(), 0, dataLength);
                    System.out.println("UDPSearcher receive from ip:" + ip
                            + "\tport:" + port + "\tdata:" + data);

                    String sn = MessageCreator.parseSn(data);
                    if (sn != null) {
                        Device device = new Device(port, ip, sn);
                        devices.add(device);
                    }
                }
            } catch (Exception e) {

            } finally {
                close();
            }
            System.out.println("UDPSearcher listener finished");
        }

        public List<Device> getDevicesAndClose() {
            done = true;
            close();
            return devices;
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        /**
         * 结束
         */
        void exit() {
            done = true;
            close();
        }
    }

}
