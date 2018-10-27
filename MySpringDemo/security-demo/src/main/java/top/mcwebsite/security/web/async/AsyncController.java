package top.mcwebsite.security.web.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.LinkedHashSet;
import java.util.concurrent.Callable;


/**
 * @author mengchen
 * @time 18-8-2 上午8:36
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

//    @RequestMapping("/order")
//    public Callable<String> order() throws InterruptedException {
//        logger.info("主线程开始");
//        Callable<String> result = () -> {
//            logger.info("副线程开始");
//            Thread.sleep(1000);
//            logger.info("副线程返回");
//            return "success";
//        };
//        logger.info("主线程返回");
//        return result;
//    }

    @RequestMapping("/order")
    public DeferredResult<String> order() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
//        Callable<String> result = () -> {
//            logger.info("副线程开始");
//            Thread.sleep(1000);
//            logger.info("副线程返回");
//            return "success";
//        };
        logger.info("主线程返回");
        return result;
    }
}

class C {
    public void A() {
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
             B();
        }, "aaa").start();
    }

    public void B() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        C c = new C();
        c.A();
    }
}