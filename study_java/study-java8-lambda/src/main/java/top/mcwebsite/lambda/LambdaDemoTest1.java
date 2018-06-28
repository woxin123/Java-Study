package top.mcwebsite.lambda;

@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);
    default int add(int x, int y) {
        return x + y;
    }
}
@FunctionalInterface
interface Interface2 {
    int doubleNum(int i);
    default int add(int x, int y) {
        return x + y;
    }
}

interface  Interface3 extends Interface1, Interface2 {

    @Override
    default int add(int x, int y) {
        return Interface1.super.add(x, y);
    }
}

public class LambdaDemoTest1 {
    public static void main(String[] args) {
        Interface1 i1 = (i) -> i * 2;
        Interface1 i2 = i -> i * 2;
        Interface1 i3 = (int i) -> i * 2;
        Interface1 i4 = (int i) -> {
            System.out.println(i * 3);
            return i * 2;
        };
        System.out.println(i1.add(2, 3));
        System.out.println(i4.doubleNum(3));
    }

}
