package top.mcwebsite.eventinaction.mcevent;

import org.springframework.context.ApplicationEvent;
import top.mcwebsite.eventinaction.util.MealEnum;

public class MealEvent extends ApplicationEvent {

    private MealEnum mealEnum;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MealEvent(String mealContent, MealEnum mealEnum) {
        super(mealContent);
        this.mealEnum = mealEnum;
    }

    public MealEnum getMealEnum() {
        return mealEnum;
    }
}
