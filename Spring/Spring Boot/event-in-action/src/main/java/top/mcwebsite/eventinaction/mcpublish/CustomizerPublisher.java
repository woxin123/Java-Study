package top.mcwebsite.eventinaction.mcpublish;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import top.mcwebsite.eventinaction.mcevent.MealEvent;

@Component
public class CustomizerPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(MealEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
