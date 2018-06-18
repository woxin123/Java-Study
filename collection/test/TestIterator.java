import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator iterator = list.iterator();
        list.add(3);
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}