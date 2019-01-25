package org.doit.config;

import org.doit.service.UserService;
import org.doit.util.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public UserService userService() {
        return mock(UserService.class);
    }
}
