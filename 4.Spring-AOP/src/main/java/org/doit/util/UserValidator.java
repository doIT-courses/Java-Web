package org.doit.util;

import org.doit.model.User;
import org.doit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Aidar Shaifutdinov.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.getOne(user.getEmail()) != null) {
            errors.rejectValue(
                    "email", "", "This email is already in use"
            );
        }
    }

}
