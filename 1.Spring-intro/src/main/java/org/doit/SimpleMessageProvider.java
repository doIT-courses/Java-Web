package org.doit;

import org.springframework.stereotype.Component;

/**
 * @author Aidar Shaifutdinov.
 */
@Component
public class SimpleMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }

}
