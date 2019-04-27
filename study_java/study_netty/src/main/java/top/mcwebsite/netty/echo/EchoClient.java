package top.mcwebsite.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author mengchen
 * @time 19-4-20 下午3:34
 */
public class EchoClient {

    private final String host;

    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建一个EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 初始化一个客户端
            Bootstrap b = new Bootstrap();
            b.group(group)
                    // 设置为NioSocketChannel
                    .channel(NioSocketChannel.class)
                    // 绑定远程的主机和端口
                    .remoteAddress(new InetSocketAddress(host, port))
                    // 当连接被创建时，一个EchoClientHandler实例会被安装到了（该Channel的）ChannelPipeline链中
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.out.println("Usage: " + EchoClient.class.getSimpleName() +
                    " <host> <port>");
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EchoClient(host, port).start();
    }
}
