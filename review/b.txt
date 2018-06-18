package top.mcwebsite.java.nio2Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesTest {

    public static void main(String[] args) throws IOException {
        // 文件复制
        Files.copy(Paths.get("E:\\project\\Java Study\\review\\src\\main\\java\\top\\mcwebsite\\java\\n" +
                        "io2Test\\FilesTest.java"),
                new FileOutputStream("b.txt"));
        // 判断文件是否为隐藏文件
        System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(Paths.get("E:\\project\\Java Study\\review" +
                "\\src\\main\\java\\top\\mcwebsite\\java\\nio2Test\\FilesTest.java")));
        // 一次性读取FileTest.java的所有行
        List<String> lines = Files.readAllLines(Paths.get("E:\\project\\Java Study\\review\\src\\main\\java\\top\\mcwebsite\\java\\n" +
                "io2Test\\FilesTest.java"), Charset.forName("UTF-8"));
        System.out.println(lines);
        // 判断文件大小
        System.out.println("FilesTest.java的文件大小为：" + Files.size(Paths.get("E:\\project\\Java Study\\" +
                "review\\src\\main\\java\\top\\mcwebsite\\java\\nio2Test\\FilesTest.java")));

        Files.lines(Paths.get("E:\\project\\Java Study\\review\\src\\main\\java\\top" +
                "\\mcwebsite\\java\\nio2Test\\FilesTest.java"), Charset.forName("UTF-8"))
                .forEach(line -> System.out.println(line));

        FileStore cStore = Files.getFileStore(Paths.get("C:"));
        // 判断C盘的总空间、可用空间
        System.out.println("C:共有空间：" + cStore.getTotalSpace());
        System.out.println("C:可用空间：" + cStore.getUsableSpace());

    }
}
