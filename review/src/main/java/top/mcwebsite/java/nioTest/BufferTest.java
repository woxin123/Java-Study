package top.mcwebsite.java.nioTest;

import java.nio.CharBuffer;

public class BufferTest {

    public static void main(String[] args) {
        // 创建一个CharBuffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity: " + buff.capacity());
        System.out.println("limit: " + buff.limit());
        System.out.println("position: " + buff.position());
        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        // 放入三个元素后的位置
        System.out.println("position: " + buff.position());
        // 对用flip方法
        buff.flip();
        System.out.println("调用flip后的position: " + buff.position());
        System.out.println("调用flip后的limit: " + buff.limit());
        // 取出第一个元素
        System.out.println("第一个元素是：" + buff.get());
        System.out.println("取出第一个元素后, position: " + buff.position());
        // 调用clear()方法
        System.out.println("调用clear()方法之后的limit: " + buff.limit());
        System.out.println("调用clear()方法之后的position: " + buff.get(2));
        buff.clear();
    }
}
