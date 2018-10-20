package top.mcwebsite.concurrency.aotmicdemo;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author mengchen
 * @time 18-10-10 下午6:49
 */
public class LockFreeVector<E> {

    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;

    private AtomicReference<Descriptor<E>> descriptor;

    public LockFreeVector() {
        this.buckets = new AtomicReferenceArray<>(30);
        buckets.set(0, new AtomicReferenceArray<>(8));
        descriptor = new AtomicReference<>(new Descriptor<>(0, null));
    }


    static class Descriptor<E> {
        public int size;
        volatile WriteDescriptor<E> writeop;

        public Descriptor(int size, WriteDescriptor<E> writeop) {
            this.size = size;
            this.writeop = writeop;


        }

        public void completeWrite() {
            WriteDescriptor<E> tempop = writeop;

            if (tempop != null) {
                writeop = null;
            }
        }
    }

    static class WriteDescriptor<E> {
        public E oldV;
        public E newV;
        public AtomicReferenceArray<E> addr;
        public int addr_Ind;

        public WriteDescriptor(AtomicReferenceArray<E> addr, int addr_Ind, E oldV, E newV) {
            this.oldV = oldV;
            this.newV = newV;
            this.addr = addr;
            this.addr_Ind = addr_Ind;
        }

        public void doIt() {
            addr.compareAndSet(addr_Ind, oldV, newV);
        }
    }
}
