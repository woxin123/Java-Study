package top.mcwebsite.java.nioTest;

import sun.misc.CharacterDecoder;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args) {
        File f = new File("E:\\project\\Java Study\\review\\src\\main\\java\\top\\mcwebsite\\java\\nioTest\\FileChannelTest.java");
        try (
                FileChannel inChannel = new FileInputStream(f).getChannel();
                FileChannel outChannel = new FileOutputStream("a.txt").getChannel()) {
            // 将FileChannel的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            // 使用UTF-8创建解码器
            Charset charset = Charset.forName("UTF-8");
            // 直接将buff中的内容输出
            outChannel.write(buffer);
            // 调用buff的clear方法，复原position和limit的位置
            buffer.clear();
            // 创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将byteBuffer变成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // 使用CharBuffer的toString()获取对应的字符串
            System.out.println(charBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
