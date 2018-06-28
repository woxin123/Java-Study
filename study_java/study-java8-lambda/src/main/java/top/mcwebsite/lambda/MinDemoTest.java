package top.mcwebsite.lambda;


import java.util.stream.IntStream;

public class MinDemoTest {
    public static void main(String[] args) {
        int[] nums = {33, 12, 32, -123};
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num)
                min = num;
        }
        System.out.println(min);

        // jdk8
        int min2 = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(min2);
    }
}
