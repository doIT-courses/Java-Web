package org.doit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aidar Shaifutdinov.
 */
@Component
public class SimpleMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;

    @Autowired
    public SimpleMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }

}
