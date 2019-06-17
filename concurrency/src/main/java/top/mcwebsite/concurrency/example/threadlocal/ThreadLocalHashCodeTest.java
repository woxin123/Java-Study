package top.mcwebsite.concurrency.example.threadlocal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mengchen
 * @time 19-4-22 下午8:18
 */
public class ThreadLocalHashCodeTest {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        int hashCode = 0;
        int size = 1 << 5;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            hashCode = i * HASH_INCREMENT;
            if (set.contains(hashCode & (size - 1))) {
                System.out.println("重复");
            }
            set.add(hashCode & (size - 1));
            System.out.print((hashCode & (size - 1)) + " ");
        }
        System.out.println();
    }

}
