import java.util.*;

public class TestListIterator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ListIterator<Integer> iterator =  list.listIterator(0);
        // while (iterator.hasPrevious()) {
        //     System.out.println(iterator.previous());
        // }
        System.out.println(iterator.next());
        iterator.set(3);
        System.out.println(iterator.previous());
    }
}