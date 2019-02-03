package org.doit.util;

import org.doit.config.TestConfig;
import org.doit.model.User;
import org.doit.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserValidatorTest {

    @Autowired
    private UserValidator userValidator;

    // mocked dependencies
    @Autowired
    private UserService userService;

    private static final String userEmail = "asd@gmail.com";
    private static final User user = mock(User.class);

    @BeforeAll
    public static void setup() {
        when(user.getEmail()).thenReturn(userEmail);
    }

    @Test
    public void validateShouldAcceptUserWithNewEmail() {
        when(userService.getOne(userEmail)).thenReturn(null);
        Errors errors = mock(Errors.class);
        userValidator.validate(user, errors);
        verify(errors, never()).rejectValue(eq("email"), any(), any());
    }

    @Test
    public void validateShouldRejectUserWithAlreadyUsedEmail() {
        when(userService.getOne(userEmail)).thenReturn(user);
        Errors errors = mock(Errors.class);
        userValidator.validate(user, errors);
        verify(errors, times(1))
                .rejectValue(eq("email"), any(), any());
    }
}
