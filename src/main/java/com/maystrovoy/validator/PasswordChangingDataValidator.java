package com.maystrovoy.validator;

import com.maystrovoy.dao.PersonDAO;
import com.maystrovoy.model.PasswordChangingFormData;
import com.maystrovoy.model.Person;
import com.maystrovoy.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordChangingDataValidator implements Validator {

    @Inject
    PersonDAO personDAO;

    @Override
    public boolean supports(Class clazz) {
        return PasswordChangingFormData.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors error) {
        PasswordChangingFormData passwordChangingFormData = (PasswordChangingFormData) object;
        String login = passwordChangingFormData.getLogin();
        Person person = personDAO.getPersonByLogin(login);
        String currentPassword = passwordChangingFormData.getCurrentPassword();
        String newPassword = passwordChangingFormData.getNewPassword();
        String repeatPassword = passwordChangingFormData.getRepeatPassword();

        ValidationUtils.rejectIfEmpty(error, "currentPassword", "personerr.password", "Required field");
        ValidationUtils.rejectIfEmpty(error, "newPassword", "personerr.password", "Required field");
        ValidationUtils.rejectIfEmpty(error, "repeatPassword", "personerr.password", "Required field");
        try {
            if (!error.hasFieldErrors("currentPassword") && !PersonService.getHashedPassword(currentPassword,
                    person.getCreationDay()).equals(person.getPassword())) {
                error.rejectValue("currentPassword", "personerr.password.invalid", "Password error");
            } else {
                if (!error.hasFieldErrors("newPassword") && !error.hasFieldErrors("repeatPassword") &&
                        !newPassword.equals(repeatPassword)) {
                    error.rejectValue("repeatPassword", "personerr.password.repeat", "Password error");
                }
                try {
                    if (!error.hasFieldErrors("newPassword") && !error.hasFieldErrors("repeatPassword") &&
                            PersonService.getHashedPassword(newPassword,
                                    person.getCreationDay()).equals(person.getPassword())) {
                        error.rejectValue("newPassword", "personerr.password.equals", "Required field");
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
