package top.mcwebsite.eventinaction.mclistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.mcwebsite.eventinaction.mcevent.TroubleEvent;

@Component
public class TroubleListener implements ApplicationListener<TroubleEvent> {

    @Override
    public void onApplicationEvent(TroubleEvent event) {
        System.out.println("---------->event: " + event);
    }
}
