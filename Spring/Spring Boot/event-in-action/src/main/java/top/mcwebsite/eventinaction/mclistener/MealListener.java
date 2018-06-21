package top.mcwebsite.eventinaction.mclistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.mcwebsite.eventinaction.mcevent.MealEvent;

@Component
public class MealListener implements ApplicationListener<MealEvent> {
    @Override
    public void onApplicationEvent(MealEvent event) {
        System.out.println(String.format("---------->thread:%s, type=%s, event: %s\n",
                Thread.currentThread().getName(), event.getMealEnum(), event));
        dispatchEvent(event);
    }

    private void dispatchEvent(MealEvent event) {
        switch (event.getMealEnum()) {
            case breakfast:
                System.out.println(event.getMealEnum() + "to handle");
                break;
            case lunch:
                System.out.println(event.getMealEnum() + "to handle");
                break;
            case dinner:
                System.out.println(event.getMealEnum() + "to handle");
                break;
        }
    }
}
