package org.doit;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Aidar Shaifutdinov.
 */
public class MessageFactory {

    private static MessageProvider provider;
    private static MessageRenderer renderer;

    static {
        Properties properties = new Properties();
        try (InputStream in = MessageFactory.class
                .getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            String messageProviderClass = properties.getProperty("messageProviderClass");
            String messageRendererClass = properties.getProperty("messageRendererClass");
            provider = (MessageProvider) Class.forName(messageProviderClass).newInstance();
            renderer = (MessageRenderer) Class.forName(messageRendererClass)
                    .getConstructor(MessageProvider.class).newInstance(provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MessageProvider getProvider() {
        return provider;
    }

    public static MessageRenderer getRenderer() {
        return renderer;
    }

}
