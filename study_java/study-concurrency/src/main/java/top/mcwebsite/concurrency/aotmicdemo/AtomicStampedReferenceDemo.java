package top.mcwebsite.concurrency.aotmicdemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author mengchen
 * @time 18-10-10 下午5:21
 */
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {

            final int timeStamp = money.getStamp();
            new Thread(() -> {
                while (true) {
                    while (true) {
                        Integer m = money.getReference();

                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20, timeStamp, timeStamp + 1)) {
                                System.out.println("余额小于20元，充值成功，余额：" + money.getReference() + "元");
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }

            }).start();
        }

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                while (true) {
                    int timeStamp = money.getStamp();
                    Integer m = money.getReference();

                    if (m > 10) {
                        System.out.println("大于10元");
                        if (money.compareAndSet(m, m - 10, timeStamp, timeStamp + 1)) {
                            System.out.println("成功消费10元，余额：" + money.getReference());
                            break;
                        }
                    } else {
                        System.out.println("没有足够的金额");
                        break;
                    }
                }
            }
        }).start();
    }

}
