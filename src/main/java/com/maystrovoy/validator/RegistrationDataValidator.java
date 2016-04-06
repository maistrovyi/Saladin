package com.maystrovoy.validator;

import com.maystrovoy.dao.PersonDAO;
import com.maystrovoy.model.Person;
import com.maystrovoy.model.RegistrationFormData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.inject.Inject;
import java.util.Date;

@Component
public class RegistrationDataValidator implements Validator {

    @Inject
    PersonDAO personDAO;

    @Override
    public boolean supports(Class clazz) {
        return RegistrationFormData.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors error) {
        RegistrationFormData registrationData = (RegistrationFormData) object;
        Person person = registrationData.getPerson();
        person.setCreationDate(new Date());
        String repeatPassword = registrationData.getRepeatPassword();

        error.pushNestedPath("person");
        ValidationUtils.rejectIfEmpty(error, "firstName", "personerr.firstname", "Required field");
        ValidationUtils.rejectIfEmpty(error, "secondName", "personerr.secondname", "Required field");
        ValidationUtils.rejectIfEmpty(error, "loginName", "personerr.loginname", "Required field");
        ValidationUtils.rejectIfEmpty(error, "password", "personerr.password", "Required field");
        if (!error.hasFieldErrors("password") && !repeatPassword.equals(person.getPassword())) {
            error.rejectValue("password", "personerr.password.repeat", "Password error");
        }
        if (!error.hasFieldErrors("loginName") && personDAO.isLoginExist(person.getLoginName())) {
            error.rejectValue("loginName", "personerr.loginname.reserved", "Login error");
        }
        error.popNestedPath();
    }

}