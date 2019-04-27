package top.mcwebsite.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import top.mcwebsite.netty.bio.helloworld.Server;

import java.net.InetSocketAddress;

/**
 * @author mengchen
 * @time 19-4-20 下午3:11
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        // 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    // 指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    // 添加一个EchoServerHandler到Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // EchoServerHandler被标注为@Sharable，所以我们可以总是使用同样的实例
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            // 异步地绑定服务器；调用sync()方法阻塞等待知道绑定完成
            ChannelFuture f = b.bind().sync();
            // 获取Channel的CloseFuture，并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        } finally {
            // 关闭EventLoopGroup，释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
}
