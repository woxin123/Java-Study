package top.mcwebsite.java.nioTest;

import sun.misc.CharacterDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) {
        try (
            // 创建文件输入流
            FileInputStream fis = new FileInputStream("E:\\project\\Java Study\\review\\src\\main\\java\\top\\mcwebsite\\java\\nioTest\\ReadFile.java");
            FileChannel channel = fis.getChannel()) {
            // 定义一个ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(256);
            // 将FileChannel的数据放入buffer中
            while (channel.read(buffer) != -1) {
                // 锁定空白区
                buffer.flip();
                // 创建一个Charset对象
                Charset charset = Charset.forName("UTF-8");
                // 创建一个解码器（CharsetDecoder）对象
                CharsetDecoder decoder = charset.newDecoder();
                // 将ByteBuffer转化为CharsetBuffer
                CharBuffer charBuffer = decoder.decode(buffer);
                System.out.println(charBuffer);
                // 将ByteBuffer初始化为下一次的读取数据做准备
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
