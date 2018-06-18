package top.mcwebsite.java.nio2Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        // 以当前的路径来蒋健Path对象
        Path path = Paths.get(".");
        System.out.println("path李包含的路径数量：" + path.getNameCount());
        // 获取path的绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println("absolutePath的跟路径：" + absolutePath.getRoot());
        System.out.println("获取绝对路径中包含的路径数量：" + absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));
        // 以多个String来构造Path对象
        Path path2 = Paths.get("g:", "boot", "TRANS.TBL");
        System.out.println(path2);
    }
}
