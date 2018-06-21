package top.mcwebsite.eventinaction.mcevent;

import org.springframework.context.ApplicationEvent;

public class TroubleEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TroubleEvent(Object source) {
        super(source);
    }
}
