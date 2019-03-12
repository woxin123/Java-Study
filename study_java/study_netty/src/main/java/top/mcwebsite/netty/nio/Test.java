package top.mcwebsite.netty.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-3-3 下午9:41
 */
public class Test {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        System.out.println(Arrays.toString(bytes));
        buffer.put(bytes);
        buffer.flip();
        byte[] newbytes = new byte[buffer.remaining()];
        buffer.get(newbytes);
        System.out.println(new String(newbytes));
    }
}
