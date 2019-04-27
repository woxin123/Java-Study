package top.mcwebsite.netty.netty_time_server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.mcwebsite.netty.nio.TimeClientHandle;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/**
 * @author mengchen
 * @time 19-4-27 下午4:58
 */
public class TimeClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger logger = Logger.getLogger(TimeClientHandle.class.getName());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("QUERY TIME ORDER", StandardCharsets.UTF_8));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("Nio is : " + msg.toString(StandardCharsets.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("Unexpected exception from downstream : " + cause.getMessage());
        ctx.close();
    }
}
