package top.mcwebsite.netty.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * @author mengchen
 * @time 19-3-7 下午2:54
 */
public class RandomFileChannelTest {

    public static void main(String[] args) {
        File file = new File("a.txt");
        try (RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
                FileChannel randomChannel = randomFile.getChannel()) {
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_WRITE, 0, 100);
            byte[] bytes = new byte[100];
            buffer.get(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
