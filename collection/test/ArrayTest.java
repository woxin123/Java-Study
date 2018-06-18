import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        // Array.copyOf()的用法
        System.out.println("-------------Arrays.copyOf()的用法示例-------------");
        Object[] array = new Object[1];
        array[0] = "Hello";
        array = Arrays.copyOf(array, 3);
        for(Object o : array) {
            System.out.print((String)o);
        }
        System.out.println();
        array[1] = " ";
        array[2] = "World!";
        for(Object o : array) {
            System.out.print((String)o);
        }
        System.out.println("-------------System.arraycopy()的用法示例---------------");
        int[] arraySrc = new int[9];
        for (int i = 0; i < 9; i++) {
            arraySrc[i] = i;
        }
        int[] arrayDest = new int[10];
        System.arraycopy(arraySrc, 0, arrayDest, 0, 9);
        for (int i = 0; i < 10; i++) {
            System.out.println(arrayDest[i]);
        }
    }
}