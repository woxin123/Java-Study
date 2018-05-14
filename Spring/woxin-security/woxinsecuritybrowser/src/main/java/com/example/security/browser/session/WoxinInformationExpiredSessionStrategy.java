package com.example.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author: mengchen
 * Create by 18-4-16
 */
public class WoxinInformationExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionValid(event.getRequest(), event.getResponse());

    }

    public WoxinInformationExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

}
