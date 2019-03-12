package top.mcwebsite.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mengchen
 * @time 19-3-3 下午8:20
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {
            // 打开多路复用器
            this.selector = Selector.open();
            // 打开ServerSocketChannel，用于监听客户端连接，它是所有客户端连接的父管道
            this.serverChannel = ServerSocketChannel.open();
            // 设置非阻塞
            this.serverChannel.configureBlocking(false);
            // 绑定监听端口
            this.serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            // 将serverChannel注册到多路复用器selector上，监听ACCEPT事件

            /**
             * public final SelectionKey register(Selector sel, int ops)
             *
             * 第一个参数是一个Selector，第二个参数是感兴趣的事件（操作）集合，可以监听下面四中不同的事件
             *
             * SelectionKey中定义的四中事件：
             * 1. OP_READ 读就绪事件
             * 2. OP_WRITE 写就绪事件
             * 3. OP_CONNECT 连接就绪事件
             * 4. OP_ACCEPT 有新连接请求连接就绪事件：表示服务器监听到了新连接，服务器可以处理这个连接了
             */
            SelectionKey selectionKey = this.serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            /*
            注册的channel的感兴趣事件
            int interestSet = selectionKey.interestOps();
            boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            boolean isInterestedInConnect  = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
            boolean isInterestedInRead  = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
            boolean isInterestedInWrite  = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;
            System.out.println(isInterestedInAccept + " " + isInterestedInConnect + " " + isInterestedInRead + " " + isInterestedInWrite);
             */
            /**
             * ready集合
             * int readySet = selectionKey.readyOps();
             * 可以和上面检测interest事件一样，来检测channel事件中的什么事件已经就绪，也可以使用下面的四个方法
             * boolean acceptable = selectionKey.isAcceptable();
             * boolean connectable = selectionKey.isConnectable();
             * boolean readable = selectionKey.isReadable();
             * boolean writable = selectionKey.isWritable();
             */
            System.out.println("The time server is start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }


    @Override
    public void run() {
        while (!this.stop) {
            try {
                /**
                 * select() 阻塞至少有一个通道在你的注册事件上就绪了
                 * select(long timeout) 和select一样，除了最长会阻塞timeout毫秒
                 * selectNow() 不会阻塞，不管什么通道就绪都立刻返回：此方法执行非阻塞的选择操作，如果上一次选择操作后，
                 *              没有通道变成可选择的，则此方法返回0
                 *
                 *
                 */
                selector.select();

                /**
                 * 获取所有的key
                 * Set<SelectionKey> allKeys = selector.keys();
                 * 获取已经就绪的keys
                 * Set<SelectionKey> selectionKeys = selector.selectedKeys();
                 *
                 */
                // 获取已经就绪的keys
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 遍历已经就绪的集合
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    // 应该每次都将调用remove()，Selector不会自己是以选择集合中移出SelectionKey实例，必须在处理完通道时自己移出
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            // 从SelectionKey中获取Channel
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (this.selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                System.out.println("A new Client join");
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order: " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                            ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }
}
