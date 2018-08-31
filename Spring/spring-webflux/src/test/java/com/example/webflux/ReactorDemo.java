package com.example.webflux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-8-23 下午10:22
 */
public class ReactorDemo {

    public static void main(String[] args) {
        // reactor = jdk8 stream + jdk9 reactive stream
        // Mono 0-1个元素
        // Flux 0-N个元素
        String[] strs = {"1", "2", "3"};

        // 定义一个订阅者
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                // 保存订阅关系，需要用它来给响应者响应
                this.subscription = subscription;

                // 请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                // 接收一个数据，处理
                System.out.println("接受到的数据：" + item);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 处理完调用request再请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                // 出现异常了
                throwable.printStackTrace();

                // 可以告诉发布者不再接受数据了
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                // 全部数据处理完了
                System.out.println("数据已经处理完毕");
            }
        };

        // 这里是jdk8的stream
        Flux.fromArray(strs).map(s -> Integer.parseInt(s))

        // 最终操作
        // 这里是jdk9的reactive stream
        .subscribe(subscriber);
    }

}
