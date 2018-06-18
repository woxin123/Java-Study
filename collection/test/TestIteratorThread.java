import java.util.*;

public class TestIteratorThread extends Thread{
    static List<Integer> list;

    public static void main(String[] args) {
        TestIteratorThread test = new TestIteratorThread();
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        test.start();
        for (int i = 3; i < 100; i++) {
            System.out.println("main");    
            list.add(i);
        }
    
    }

    public void run() {
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}