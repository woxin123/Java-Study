package top.mcwebsite.java.nioTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) {
        try (
                // 使用FileOutputStream获取FileChannel
                FileChannel channel = new FileOutputStream("a.txt").getChannel()
                ) {
            // 使用非阻塞方式对指定文件加锁
            FileLock lock = channel.tryLock();

            Thread.sleep(10 * 1000);
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
