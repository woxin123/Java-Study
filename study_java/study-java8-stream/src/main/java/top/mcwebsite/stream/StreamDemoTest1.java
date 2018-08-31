package top.mcwebsite.stream;


import java.nio.file.Files;
import java.util.stream.IntStream;

/**
 * @author mengchen
 * @date 2018/6/28 12:15
 */
public class StreamDemoTest1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // 外部迭代
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("结果为：" + sum);

        // 使用stream的内部迭代
        // map就是中间操作（返回stream的操作）
        // sum就是终止操作
        int sum2 = IntStream.of(nums).map(StreamDemoTest1 :: doubleNum).sum();
        System.out.println("结果为：" + sum2);

        System.out.println("惰性求值将终止操作没有执行之前中间操作不会执行");
        IntStream.of(nums).map(StreamDemoTest1 :: doubleNum);
    }

    public static int doubleNum(int i) {
        System.out.println("执行乘以2");
        return i * 2;
    }
}
