package top.mcwebsite.prototype_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-20 下午5:38
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Double> scores = new HashMap<>();
        scores.put("数学", 99.0);
        scores.put("英语", 99.99);

        Student student1 = new Student(1, "张三", scores);
        Student student2 = student1.clone();

        student2.setId(2);
        student2.setName("李四");
        student2.getScores().put("语文", 100.0);

        System.out.println(student1);
        System.out.println(student2);
    }
}
