
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-3-6 下午4:31
 */
public class TestEndian {

    public static void main(String[] args) {
        // 创建12个字节的字节缓冲区
        ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);

        // 存入字符
        buffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(buffer.array()));

        // 反转缓冲区
        buffer.rewind();

        // 设置字节次序
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(buffer.array()));

        System.out.println(ByteOrder.nativeOrder());
    }
}
