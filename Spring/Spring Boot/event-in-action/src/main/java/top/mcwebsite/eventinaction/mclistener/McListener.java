package top.mcwebsite.eventinaction.mclistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import top.mcwebsite.eventinaction.mcevent.McEvent;

@Component
public class McListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof McEvent) {
            System.out.println("my event laugh");
        } else {
            System.out.println("other event");
        }
    }
}
