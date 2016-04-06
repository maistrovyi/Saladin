package com.maystrovoy.validator;

import com.maystrovoy.model.PasswordChangingFormData;
import com.maystrovoy.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordChangingDataValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return PasswordChangingFormData.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors error) {
        PasswordChangingFormData passwordChangingFormData = (PasswordChangingFormData) object;
        Person person = passwordChangingFormData.getPerson();
        String newPassword = passwordChangingFormData.getNewPassword();
        String repeatPassword = passwordChangingFormData.getRepeatPassword();

        error.pushNestedPath("person");
        ValidationUtils.rejectIfEmpty(error, "password", "personerr.password", "Required field");
//        if(!error.hasFieldErrors("newPassword") && !repeatPassword.equals(person.getPassword())){
//            error.rejectValue("newPassword", "personerr.password.repeat", "Password error");
//        }
        error.popNestedPath();
    }
}
