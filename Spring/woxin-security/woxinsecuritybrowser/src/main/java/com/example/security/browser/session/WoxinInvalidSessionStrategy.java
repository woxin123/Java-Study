package com.example.security.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: mengchen
 * Create by 18-4-16
 */
public class WoxinInvalidSessionStrategy extends AbstractSessionStrategy
    implements InvalidSessionStrategy {

    public WoxinInvalidSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        onSessionValid(request, response);
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
