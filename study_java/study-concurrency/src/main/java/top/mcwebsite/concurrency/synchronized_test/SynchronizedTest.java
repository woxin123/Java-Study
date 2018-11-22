package top.mcwebsite.concurrency.synchronized_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author mengchen
 * @time 18-11-16 下午9:37
 */
public class SynchronizedTest {

    public synchronized void readFile() throws IOException {
//            File file = new File("study-concurrency/src/main/java/top/mcwebsite/concurrency/synchronized_test/SynchronizedTest.java");
//            FileReader fileReader = new FileReader(file);
//            int i = 0;
//            char[] chs = new char[1024];
//            while ((i = fileReader.read(chs)) != -1) {
//                System.out.print(new String(chs,0, i));
//            }
//            fileReader.close();
        System.out.println("同步方法");
    }

    public static void main(String[] args) throws IOException {
        SynchronizedTest s = new SynchronizedTest();
        s.readFile();
    }

}
