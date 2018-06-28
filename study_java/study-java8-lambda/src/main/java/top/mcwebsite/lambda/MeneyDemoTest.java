package top.mcwebsite.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

interface MoneyFormat {
    String format(int i);
}

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.apply(money));
    }
}

public class MeneyDemoTest {
    public static void main(String[] args) {
        MyMoney my = new MyMoney(99999999);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        my.printMoney(integerStringFunction.andThen(s -> "人名币 " + s));


    }
}
