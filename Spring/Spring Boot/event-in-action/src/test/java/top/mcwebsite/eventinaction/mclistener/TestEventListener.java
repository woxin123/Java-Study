package top.mcwebsite.eventinaction.mclistener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import top.mcwebsite.eventinaction.mcevent.MealEvent;
import top.mcwebsite.eventinaction.mcpublish.CustomizerPublisher;
import top.mcwebsite.eventinaction.util.MealEnum;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEventListener {

    @Autowired
    public WebApplicationContext webApplicationContext;

    @Test
    public void testListener() throws InterruptedException {
        String[] definitionNames = webApplicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("bean---> " + definitionName);
        }

        CustomizerPublisher customizerPublisher = webApplicationContext.getBean(CustomizerPublisher.class);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("开始吃放：");
                    MealEvent lunchEvent = new MealEvent("A吃下午饭", MealEnum.lunch);
                    MealEvent breakfastEvent = new MealEvent("B吃早饭了", MealEnum.breakfast);
                    MealEvent dinnerEvent = new MealEvent("C吃晚饭", MealEnum.dinner);
                    customizerPublisher.publishEvent(lunchEvent);
                    TimeUnit.SECONDS.sleep(11);
                    customizerPublisher.publishEvent(breakfastEvent);
                    TimeUnit.SECONDS.sleep(11);
                    customizerPublisher.publishEvent(dinnerEvent);
                    TimeUnit.SECONDS.sleep(11);
                    System.out.println("它们吃完了！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("meal-thread");
        thread.start();
        System.out.println(Thread.currentThread().getName() + " is wating for ...");
        thread.join();
        System.out.println("Done!!!!!!!!!!!!!!");
    }
}
