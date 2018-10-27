package jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 18-10-21 下午12:44
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }


    }
}
